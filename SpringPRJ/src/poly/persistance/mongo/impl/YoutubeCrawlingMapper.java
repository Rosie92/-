package poly.persistance.mongo.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import poly.dto.YoutubeDTO;
import poly.persistance.mongo.IYoutubeCrawlingMapper;
import poly.util.CmmUtil;

@Component("YoutubeCrawlingMapper")
public class YoutubeCrawlingMapper implements IYoutubeCrawlingMapper {

	@Autowired
	private MongoTemplate mongodb;

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean createCollection(String colNm) throws Exception {
		log.info(this.getClass().getName() + ".Youtube createCollection Start!");

		boolean res = false;

		// 기존에 등록된 컬렉션 이름이 존재하는지 체크하고, 존재하면 기존 컬렉션 삭제함
		if (mongodb.collectionExists(colNm)) {
			mongodb.dropCollection(colNm); // 기존 컬렉션 삭제
		}

		// 컬렉션 생성 및 인덱스 생성, MongoDB에서 데이터 가져오는 방식에 맞게 인덱스는 반드시 생성하자!
		// 데이터 양이 많지 않으면 문제되지 않으나, 최소 10만건 이상 데이터 저장시 속도가 약 10배 이상 발생함
		mongodb.createCollection(colNm).createIndex(new BasicDBObject("collect_time", 1).append("Youtube", 1), "Youtube");

		res = true;

		log.info(this.getClass().getName() + ".Youtube createCollection End!");

		return res;
	}

	@Override
	public int insertYoutube(List<YoutubeDTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertYoutube Start!");

		log.info("colNm : " + colNm);
		log.info("pList : " + pList);

		log.info("몽고디비 Youtube 인서트 실행 시작");

		mongodb.insert(pList, colNm);

		log.info("몽고디비 Youtube 인서트 실행 완료");

		return 1;
	}

	@Override
	public List<YoutubeDTO> getYoutube(String colNm) throws Exception {

		log.info(this.getClass().getName() + ".Youtube 셀렉트 매퍼 시작");

		// 데이터를 가져올 컬렉션 선택
		DBCollection rCol = mongodb.getCollection(colNm);

		// 컬렉션으로부터 전체 데이터 가져오기
		Iterator<DBObject> cursor = rCol.find();

		// 컬렉션으로부터 전체 데이터 가져온 것을 List 형태로 저장하기 위한 변수 선언
		List<YoutubeDTO> rList = new ArrayList<YoutubeDTO>();

		YoutubeDTO rDTO = null;

		while (cursor.hasNext()) {

			rDTO = new YoutubeDTO();

			final DBObject current = cursor.next();

			String Crawling_Data = CmmUtil.nvl((String) current.get("Youtube")); // 크롤링데이터

			rDTO.setYoutube(Crawling_Data);

			System.out.println("rDTO에 저장 완료");

			rList.add(rDTO); // List에 저장

			System.out.println("rList에 저장완료");

			rDTO = null;

		}

		log.info(this.getClass().getName() + ".Youtube 셀렉트 매퍼 종료");

		return rList;

	}

}
