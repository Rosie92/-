package poly.service;

import java.util.List;

import poly.dto.TitleDTO;

public interface IContentCrawlingService {

	// 크롤링 실행 후 저장
	public int collectContentCrawling() throws Exception;
	
	
	// DB에 있는 크롤링 Select
	public List<TitleDTO> getContent() throws Exception;



}
