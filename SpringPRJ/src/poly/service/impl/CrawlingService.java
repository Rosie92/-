package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.EmpathyDTO;
import poly.persistance.mongo.ICrawlingMapper;
import poly.service.ICrawlingService;

@Service("CrawlingService")
public class CrawlingService implements ICrawlingService {

	@Resource(name = "CrawlingMapper")
	private ICrawlingMapper CrawlingMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectEmpathyCrawling() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectEmpathyCrawling Start!");

		int res = 0;
		/*
		 * List<EmpathyDTO> pList = new ArrayList<EmpathyDTO>();
		 */
		// 크롤링 하는 페이지
		String url = "http://www.happypet.co.kr/news/articleList.html?sc_sub_section_code=S2N5&view_type=sm";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null;

		doc = Jsoup.connect(url).get();

		/* log.info(doc); */

		Elements element = doc.select("section.user-snb");
		/* post-area */
		/* System.out.println("element : " + element); */

		String str = element.toString();

		/* System.out.println("str : " + str.substring(0, 10)); */

		EmpathyDTO pDTO = new EmpathyDTO();

		pDTO.setEmpathy(str);

		String colNm = "Empathy"; // 생성할 컬렉션명

		// MongoDB Collection 생성하기
		CrawlingMapper.createCollection(colNm);

		log.info(this.getClass().getName() + ".insertEmpathy Method Start!");

		CrawlingMapper.insertEmpathy(pDTO, colNm);

		log.info(this.getClass().getName() + ".insertEmpathy Method End!");

		return res;
	}

	@Override
	public List<EmpathyDTO> getEmpathy() throws Exception {
		log.info(this.getClass().getName() + ".getEmpathy Select Service Start");
		
		// 조회할 컬렉션 이름
		String colNm = "Empathy";
		
		List<EmpathyDTO> rList = CrawlingMapper.getEmpathy(colNm);
		
		if (rList == null) {
			rList = new ArrayList<EmpathyDTO>();
		}
		
		log.info(this.getClass().getName() + ".getEmpathy Select Service End");
		
		return rList;
	}
}
