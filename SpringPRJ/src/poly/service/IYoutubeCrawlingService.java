package poly.service;

import java.util.List;

import poly.dto.YoutubeDTO;

public interface IYoutubeCrawlingService {

	// 크롤링 실행 후 저장
	public int collectYoutubeCrawling() throws Exception;
	
	
	// DB에 있는 크롤링 Select
	public List<YoutubeDTO> getYoutube() throws Exception;



}
