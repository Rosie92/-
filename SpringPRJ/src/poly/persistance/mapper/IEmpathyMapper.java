package poly.persistance.mapper;

import config.Mapper;
import poly.dto.EmpathyDTO;

@Mapper("EmpathyMapper")
public interface IEmpathyMapper {
	
	// 수집된 내용 DB에 등록
	int InsertEmpathy(EmpathyDTO pDTO) throws Exception;

}
