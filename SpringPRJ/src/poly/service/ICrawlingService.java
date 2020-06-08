package poly.service;

import java.util.List;

import poly.dto.EmpathyDTO;

public interface ICrawlingService {

	// 크롤링 실행 후 저장
	public int collectEmpathyCrawling() throws Exception;
	
	
	// DB에 있는 크롤링 Select
	public List<EmpathyDTO> getEmpathy() throws Exception;
}
