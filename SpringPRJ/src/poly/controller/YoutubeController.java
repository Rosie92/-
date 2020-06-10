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

import poly.dto.YoutubeDTO;
import poly.service.IYoutubeCrawlingService;

@Controller
public class YoutubeController {
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "YoutubeCrawlingService")
	private IYoutubeCrawlingService YoutubeCrawlingService;

	// 데이터 가져오기
	@RequestMapping(value = "/DExellent/getYoutube")
	@ResponseBody
	public List<YoutubeDTO> getYoutube(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".유튜브 셀렉트 컨트롤러 시작");

		List<YoutubeDTO> rList = YoutubeCrawlingService.getYoutube();

		System.out.println("List<YoutubeDTO> rList = YoutubeCrawlingService.getYoutube(); 실행됨");

		if (rList == null) {
			rList = new ArrayList<YoutubeDTO>();
		}

		log.info(this.getClass().getName() + ".유튜브 셀렉트 컨트롤러 종료");

		return rList;
	}

	
	// 데이터 가져와 jsp와 연결
	@RequestMapping(value = "/DExellent/Youtube")
	public String Youtube(HttpServletRequest requset, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".유튜브 컨트롤러 (JSP출력) 시작");

		log.info(this.getClass().getName() + ".유튜브 컨트롤러 (JSP출력) 종료");

		return "/DExellent/Youtube";
	}
}
