package poly.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IContentCrawlingService;
import poly.service.ITitleCrawlingService;
import poly.service.IYoutubeCrawlingService;
import poly.util.CmmUtil;

@Controller
public class DEController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "TitleCrawlingService")
	private ITitleCrawlingService titlecrawlingService;
	
	@Resource(name = "ContentCrawlingService")
	private IContentCrawlingService contentcrawlingService;
	
	@Resource(name = "YoutubeCrawlingService")
	private IYoutubeCrawlingService youtubecrawlingService;
	
	@RequestMapping(value = "/DExellent/index")
	public String index(HttpSession session) throws Exception {
		log.info(this.getClass().getName() + "########인덱스 화면 실행########");
		
		if (!CmmUtil.nvl((String)session.getAttribute("user_name")).equals("")) {
			titlecrawlingService.collectTitleCrawling();
			contentcrawlingService.collectContentCrawling();
			youtubecrawlingService.collectYoutubeCrawling();
		}
		return "/DExellent/index";
	}

}
