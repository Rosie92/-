package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import poly.dto.YoutubeDTO;
import poly.persistance.mongo.IYoutubeCrawlingMapper;
import poly.service.IYoutubeCrawlingService;

@Service("YoutubeCrawlingService")
public class YoutubeCrawlingService implements IYoutubeCrawlingService {

	@Resource(name = "YoutubeCrawlingMapper")
	private IYoutubeCrawlingMapper YoutubeCrawlingMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectYoutubeCrawling() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".Youtube collectContentCrawling Start!");

		int res = 0;

		List<YoutubeDTO> pList = new ArrayList<YoutubeDTO>();

		// 크롤링 하는 페이지
		String url = "https://www.youtube.com/results?search_query=%EA%B0%95%EC%95%84%EC%A7%80+%EC%9D%BC%EC%83%81";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null;

		doc = Jsoup.connect(url).get();

		String YoutubeCrawlingData = doc.toString();// or article-list-content
		/* post-area */
		/* System.out.println("element : " + element); */

		YoutubeDTO pDTO = new YoutubeDTO();

		pDTO.setYoutube(YoutubeCrawlingData);

		pList.add(pDTO);

		String colNm = "Youtube"; // 생성할 컬렉션명

		// MongoDB Collection 생성하기
		YoutubeCrawlingMapper.createCollection(colNm);

		log.info(this.getClass().getName() + ".insertYoutube Method Start!");

		YoutubeCrawlingMapper.insertYoutube(pList, colNm);

		log.info(this.getClass().getName() + ".insertYoutube Method End!");

		return res;
	}

	@Override
	public List<YoutubeDTO> getYoutube() throws Exception {
		log.info(this.getClass().getName() + ".Youtube 셀렉트 서비스 시작");

		// 조회할 컬렉션 이름
		String colNm = "Youtube";

		List<YoutubeDTO> rList = YoutubeCrawlingMapper.getYoutube(colNm);

		if (rList == null) {
			rList = new ArrayList<YoutubeDTO>();
		}

		log.info(this.getClass().getName() + ".Youtube 셀렉트 종료");

		return rList;
	}
}
