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

import poly.dto.InformationDTO;
import poly.persistance.mongo.IInformationCrawlingMapper;
import poly.service.IInformationCrawlingService;

@Service("InformationCrawlingService")
public class InformationCrawlingService implements IInformationCrawlingService {

	@Resource(name = "InformationCrawlingMapper")
	private IInformationCrawlingMapper InformationCrawlingMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectInformationCrawling() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".Information collectContentCrawling Start!");

		int res = 0;

		List<InformationDTO> pList = new ArrayList<InformationDTO>();

		// 크롤링 하는 페이지
		String url = "https://mypetlife.co.kr/wiki_category/%ea%b2%ac%ec%a2%85%eb%b0%b1%ea%b3%bc/";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null;
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div#content");
		
		/*
		 * for (Element e : element.select("div")) { if
		 * (e.className().equals("thumbimage")) { continue; } } // 이미지 태그는 빼고 크롤링
		 */
		
		Iterator<Element> Crawling = element.select("div.elementor-post__card").iterator();
		
		while (Crawling.hasNext()) {

			Element CrawlingData = Crawling.next();
			
			String Information = CrawlingData.html();
			
			// Iframe안에서의 링크 이동 허용을 위해.			
			Information = Information.replaceAll("<a ","<a target='_blank' style='text-decoration: none; font-weight: 500; color: black;'");

			int i = 0;
			Information = Information.replaceAll("src", "<!-- src");
			Information = Information.replaceAll("' class'", "' --> class'");
			Information = Information.replaceAll("height='200'", "height='200' src='../../assets/img/DEIMG/dog/a" + i + ".jpg'");
			Information = Information.replaceAll("더 보기 » </a>", "더 보기 » </a><hr style='width: 70%; margin-top: 15px; margin-bottom: 25px;'>");
			Information = Information.replaceAll("<h3", "<h3 style='font-weight: bolder;'");
			
			CrawlingData = null;

			InformationDTO pDTO = new InformationDTO();

			pDTO.setInformation(Information);

			pList.add(pDTO);
			
			i++;
		}

		String colNm = "Information"; // 생성할 컬렉션명

		// MongoDB Collection 생성하기
		InformationCrawlingMapper.createCollection(colNm);

		log.info(this.getClass().getName() + ".insert Information Method Start!");

		InformationCrawlingMapper.insertInformation(pList, colNm);

		log.info(this.getClass().getName() + ".insert Information Method End!");

		return res;
	}

	@Override
	public List<InformationDTO> getInformation() throws Exception {
		log.info(this.getClass().getName() + ".Information 셀렉트 서비스 시작");

		// 조회할 컬렉션 이름
		String colNm = "Information";

		List<InformationDTO> rList = InformationCrawlingMapper.getInformation(colNm);

		if (rList == null) {
			rList = new ArrayList<InformationDTO>();
		}

		log.info(this.getClass().getName() + ".Information 셀렉트 종료");

		return rList;
	}
}
