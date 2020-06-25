package poly.service;

import java.util.List;

import poly.dto.InformationDTO;

public interface IInformationCrawlingService {

	// 크롤링 실행 후 저장
	public int collectInformationCrawling() throws Exception;
	
	
	// DB에 있는 크롤링 Select
	public List<InformationDTO> getInformation() throws Exception;


	// 골든리트리버
	public int GoldenRetriever() throws Exception;


	public List<InformationDTO> getGoldenRetrieverJspGo() throws Exception;



}
