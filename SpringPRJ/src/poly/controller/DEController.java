package poly.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IDEService;

@Controller
public class DEController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "DEService")
	private IDEService DEService;

	@RequestMapping(value = "/DExellent/index")
	public String index() {
		log.info(this.getClass().getName() + "########인덱스 화면 실행########");

		return "/DExellent/index";
	}

}
