package poly.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.EmpathyDTO;
import poly.persistance.mapper.IEmpathyMapper;
import poly.service.IEmpathyService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("EmpathyService")
public class EmpathyService implements IEmpathyService {
	
	@Resource(name="EmpathyMapper")
	private IEmpathyMapper empathyMapper;
	
	//로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());
	
	/* JSOUP 라이브러리를 통한 크롤링하기 */

	@Override
	public int getEmpathyFromWEB(EmpathyDTO bDTO) throws Exception {
		
		log.info(this.getClass().getName() + "get동물공갑FromWEB START");
		
		int res = 0; //크롤링 겨로가 (0보다 크면 크롤링 성공)
		
		// 크롤링할 정보를 가져올 사이트 주소
		String url = "https://www.naver.com/";
		
		// JSOUP 라이브러리를 통해 사이트에 접속되면, 그 사이트 전체 HTML 소스 저장할 변수
		Document doc = null; 
		
		// 사이트 접속 (http프로토콜만 가능, https 프로토콜은 보안상 안됨)
		doc = Jsoup.connect(url).get();
		
		// 크롤링할 웹페이지의 전체 소스 중 일부 태그를 선택하기 위해 사용
		// <div class=" "> 이 태그 내에서 있는 HTML소스만 element에 저장됨
		Elements element = doc.select("data-panel-code=\"ANIMAL\"");
		
		// Iterator를 사용하여 크롤링해오기
		// 기본적으로 1개 이상의 정보가 존재하기에 태그의 반복이 존재할 수 밖에 없음
		Iterator<Element> empathy_topstory = element.select("Strong.topStory").iterator();//탑스토리
		Iterator<Element> empathy_theme1 = element.select("PC-THEME-ANIMAL-MOBILE-RANKING-DEFAULT-0").iterator();
		Iterator<Element> empathy_theme2 = element.select("PC-THEME-ANIMAL-MOBILE-RANKING-DEFAULT-1").iterator();
		
		EmpathyDTO pDTO = null;
		
		// 수집된 데이터 DB에 저장하기
		while(empathy_topstory.hasNext()) {
			pDTO = new EmpathyDTO(); // 수집된 정보를 DTO에 저장하기 위해 메모리에 올리기
			
			// 수집 시간을 기본키(PK)로 사용
			pDTO.setCheck_time(DateUtil.getDateTime("yyyyMMdd"));
			
			// 탑스토리
			pDTO.setEmpathy_topstory(CmmUtil.nvl(empathy_topstory.next().text()).trim());
			// 테마 1
			pDTO.setEmpathy_theme1(CmmUtil.nvl(empathy_theme1.next().text()).trim());
			// 테마 2
			pDTO.setEmpathy_theme2(CmmUtil.nvl(empathy_theme2.next().text()).trim());
			// 한개씩 추가
			res += empathyMapper.InsertEmpathy(pDTO);
		}
		
		log.info(this.getClass().getName() + "get동물공감FromWEB END");
		
		return res;
	}
}
