package poly.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.EmpathyDTO;
import poly.persistance.mongo.IEmpathyMapper;
import poly.service.IEmpathyService;
import poly.util.DateUtil;

@Service("EmpathyService")
public class EmpathyService implements IEmpathyService {
	
	@Resource(name="EmpathyMapper")
	private IEmpathyMapper empathyMapper; // MongoDB에 저장할 Mapper
	
	//로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public int collectEmpathyCrawling() throws Exception {
		
		//로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectEmpathyCrawling Start!");
		
		int res = 0;
		
		List<EmpathyDTO> pList = new ArrayList<EmpathyDTO>();
		
		// 크롤링 하는 페이지
		String url = "https://blog.naver.com/PostList.nhn?blogId=animalandhuman&from=postList&categoryNo=32";
		
		//JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null;
		
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div.clearfix");
		
		Iterator<Element> CrawlingData1 = element.iterator(); 
		// 크롤링을 통해 데이터 저장하기
		String CrawlingData2 = CrawlingData1.toString();
		
		CrawlingData1 = null;
		
		// MongoDB에 저장할 List 형태의 맞는 DTO 데이터 저장하기
		EmpathyDTO pDTO = new EmpathyDTO();
		pDTO.setEmpathy(CrawlingData2);
		/*
		 * //한번에 여러개의 데이터를 MongoDB에 저장할 List 형태의 데이터 저장하기 pList.add(pDTO);
		 */
		
	String colNm = "Empathy"; //생성할 컬렉션명
	
	// MongoDB Collection 생성하기
	empathyMapper.createCollection(colNm);
	
	empathyMapper.insertEmpathy(pDTO,colNm);
	
	return res;
	}
}


