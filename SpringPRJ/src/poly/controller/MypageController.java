package poly.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IDEService;

@Controller
public class MypageController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	/*
	 * @Resource(name = "DEService") 
	 * private IDEService DEService;
	 */
	@RequestMapping(value = "/DExellent/mypage")
	public String index() {
		log.info(this.getClass().getName() + "########마이페이지 화면 실행########");

		return "/DExellent/mypage";
	}

}
