package poly.dto;

import org.springframework.data.annotation.Id;

public class EmpathyDTO {

	@Id
	private String empathy;

	public String getEmpathy() {
		return empathy;
	}

	public void setEmpathy(String empathy) {
		this.empathy = empathy;
	}
	
}
