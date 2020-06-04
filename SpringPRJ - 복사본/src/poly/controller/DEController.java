package poly.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IDEService;
import poly.service.IEmpathyService;
import poly.util.CmmUtil;

@Controller
public class DEController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "DEService")
	private IDEService DEService;
	
	@Resource(name = "EmpathyService")
	private IEmpathyService empathyService;
	
	@RequestMapping(value = "/DExellent/index")
	public String index(HttpSession session) throws Exception {
		log.info(this.getClass().getName() + "########인덱스 화면 실행########");
		
		if (!CmmUtil.nvl((String)session.getAttribute("user_name")).equals("")) {
			empathyService.collectEmpathyCrawling();
		}
		return "/DExellent/index";
	}

}
