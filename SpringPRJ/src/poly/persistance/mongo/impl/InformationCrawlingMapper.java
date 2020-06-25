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

import poly.dto.InformationDTO;
import poly.persistance.mongo.IInformationCrawlingMapper;
import poly.util.CmmUtil;

@Component("InformationCrawlingMapper")
public class InformationCrawlingMapper implements IInformationCrawlingMapper {

	@Autowired
	private MongoTemplate mongodb;

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean createCollection(String colNm) throws Exception {
		log.info(this.getClass().getName() + ".Information createCollection Start!");

		boolean res = false;

		// 기존에 등록된 컬렉션 이름이 존재하는지 체크하고, 존재하면 기존 컬렉션 삭제함
		if (mongodb.collectionExists(colNm)) {
			mongodb.dropCollection(colNm); // 기존 컬렉션 삭제
		}

		// 컬렉션 생성 및 인덱스 생성, MongoDB에서 데이터 가져오는 방식에 맞게 인덱스는 반드시 생성하자!
		// 데이터 양이 많지 않으면 문제되지 않으나, 최소 10만건 이상 데이터 저장시 속도가 약 10배 이상 발생함
		mongodb.createCollection(colNm).createIndex(new BasicDBObject("collect_time", 1).append("Information", 1), "Information");

		res = true;

		log.info(this.getClass().getName() + ".Information createCollection End!");

		return res;
	}

	@Override
	public int insertInformation(List<InformationDTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertInformation Start!");

		log.info("colNm : " + colNm);
		log.info("pList : " + pList);

		log.info("몽고디비 Information 인서트 실행 시작");

		mongodb.insert(pList, colNm);

		log.info("몽고디비 Information 인서트 실행 완료");

		return 1;
	}

	@Override
	public List<InformationDTO> getInformation(String colNm) throws Exception {

		log.info(this.getClass().getName() + ".Information 셀렉트 매퍼 시작");

		// 데이터를 가져올 컬렉션 선택
		DBCollection rCol = mongodb.getCollection(colNm);
		System.out.println("##################데이터를 가져올 컬렉션 선택##############");
		// 컬렉션으로부터 전체 데이터 가져오기
		Iterator<DBObject> cursor = rCol.find();
		System.out.println("########컬렉션으로부터 전체 데이터 가져오기 ###########");
		// 컬렉션으로부터 전체 데이터 가져온 것을 List 형태로 저장하기 위한 변수 선언
		List<InformationDTO> rList = new ArrayList<InformationDTO>();
		
		InformationDTO rDTO = null;

		while (cursor.hasNext()) {

			rDTO = new InformationDTO();

			final DBObject current = cursor.next();
			System.out.println("#################### current에 cursor.next실행 #######################");
			String Crawling_Data = CmmUtil.nvl((String) current.get("information")); // 크롤링데이터
			System.out.println("########### Crawling_data에 current.get('Information') 실행완료 ###############");
			rDTO.setInformation(Crawling_Data);
			
			System.out.println("rDTO에 저장 완료");

			rList.add(rDTO); // List에 저장

			System.out.println("rList에 저장완료");

			rDTO = null;

		}

		log.info(this.getClass().getName() + ".Information 셀렉트 매퍼 종료");

		return rList;

	}
	
	
	//==========================견종백과===========================
	// 골든리트리버
	@Override
	public boolean createCollectionGoldenRetriever(String colNm) throws Exception {
		log.info(this.getClass().getName() + ".Information createCollectionGoldenRetriever Start!");

		boolean res = false;

		// 기존에 등록된 컬렉션 이름이 존재하는지 체크하고, 존재하면 기존 컬렉션 삭제함
		if (mongodb.collectionExists(colNm)) {
			mongodb.dropCollection(colNm); // 기존 컬렉션 삭제
		}

		// 컬렉션 생성 및 인덱스 생성, MongoDB에서 데이터 가져오는 방식에 맞게 인덱스는 반드시 생성하자!
		// 데이터 양이 많지 않으면 문제되지 않으나, 최소 10만건 이상 데이터 저장시 속도가 약 10배 이상 발생함
		mongodb.createCollection(colNm).createIndex(new BasicDBObject("collect_time", 1).append("GoldenRetriever", 1), "GoldenRetriever");

		res = true;

		log.info(this.getClass().getName() + ".Information createCollectionGoldenRetriever End!");

		return res;
	}
	@Override
	public int insertInformationGoldenRetriever(List<InformationDTO> pList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertInformationGoldenRetriever Start!");

		log.info("colNm : " + colNm);
		log.info("pList : " + pList);

		log.info("몽고디비 GoldenRetriever 인서트 실행 시작");

		mongodb.insert(pList, colNm);

		log.info("몽고디비 GoldenRetriever 인서트 실행 완료");

		return 1;
	}
	@Override
	public List<InformationDTO> getGoldenRetriever(String colNm) throws Exception {
		log.info(this.getClass().getName() + ".GoldenRetriever 셀렉트 매퍼 시작");
		// 데이터를 가져올 컬렉션 선택
		DBCollection rCol = mongodb.getCollection(colNm);
		System.out.println("##################데이터를 가져올 컬렉션 선택##############");
		// 컬렉션으로부터 전체 데이터 가져오기
		Iterator<DBObject> cursor = rCol.find();
		System.out.println("########컬렉션으로부터 전체 데이터 가져오기 ###########");
		// 컬렉션으로부터 전체 데이터 가져온 것을 List 형태로 저장하기 위한 변수 선언
		List<InformationDTO> aList = new ArrayList<InformationDTO>();
		
		InformationDTO rDTO = null;

		while (cursor.hasNext()) {

			rDTO = new InformationDTO();

			int i = 0;
			final DBObject current = cursor.next();
			System.out.println("#################### current에 cursor.next실행 #######################");
			String Crawling_Data = CmmUtil.nvl((String) current.get("information")); // 크롤링데이터
			System.out.println("########### Crawling_data에 current.get('GoldenRetriever') 실행완료 ###############");
			rDTO.setInformation(Crawling_Data);
			
			System.out.println("rDTO에 저장 완료");

			aList.add(rDTO); // List에 저장

			System.out.println("aList에 저장완료 : " + aList.get(i).getInformation());

			rDTO = null;
			i++;
		}

		log.info(this.getClass().getName() + ".GoldenRetriever 셀렉트 매퍼 종료");

		return aList;

	}

}
