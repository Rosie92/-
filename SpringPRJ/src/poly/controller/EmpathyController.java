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

import poly.dto.EmpathyDTO;
import poly.service.ICrawlingService;

@Controller
public class EmpathyController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "CrawlingService")
	private ICrawlingService CrawlingService;

	// 데이터 가져오기
	@RequestMapping(value = "/DExellent/getEmpathy")
	@ResponseBody
	public List<EmpathyDTO> getEmpathy(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".getEmpathy Select Controller Start");

		List<EmpathyDTO> rList = CrawlingService.getEmpathy();

		System.out.println("List<EmpathyDTO> rList = CrawlingService.getEmpathy(); 실행됨");

		System.out.println("rList : " + rList);

		if (rList == null) {
			rList = new ArrayList<EmpathyDTO>();
		}
		System.out.println("IF문 실행됨");

		log.info(this.getClass().getName() + ".getEmpathy Select controller End");

		return rList;
	}

	// 데이터 가져와 jsp와 연결
	@RequestMapping(value = "/DExellent/empathy")
	public String empathy(HttpServletRequest requset, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".Empathy JSP Controller Start");

		log.info(this.getClass().getName() + ".Empathy JSP Controller End");

		return "/DExellent/empathy";
	}
}
