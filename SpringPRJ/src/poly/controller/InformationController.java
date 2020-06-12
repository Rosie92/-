package poly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.InformationDTO;
import poly.service.IInformationCrawlingService;

@Controller
public class InformationController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "InformationCrawlingService")
	private IInformationCrawlingService InformationCrawlingService;

	// 데이터 가져오기
	@RequestMapping(value = "/DExellent/getInformation")
	@ResponseBody
	public List<InformationDTO> getInformation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".Information 셀렉트 컨트롤러 시작");

		List<InformationDTO> rList = InformationCrawlingService.getInformation();

		System.out.println("List<InformationDTO> rList = InformationCrawlingService.getInformation(); 실행됨");

		if (rList == null) {
			rList = new ArrayList<InformationDTO>();
		}

		log.info(this.getClass().getName() + ".Information 셀렉트 컨트롤러 종료");

		return rList;
	}

	
	// 데이터 가져와 jsp와 연결
	@RequestMapping(value = "/DExellent/Information")
	public String Information(HttpServletRequest requset, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".Information 컨트롤러 (JSP출력) 시작");

		log.info(this.getClass().getName() + ".Information 컨트롤러 (JSP출력) 종료");

		return "/DExellent/Information";
	}
}
