package poly.controller;

import poly.service.impl.KakaoService;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
/*import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

@Controller
public class KakaoController {

    @Autowired
    private KakaoService kakao;

    @RequestMapping(value="/")
    public String index() throws Exception{
    	return "/DExellent/index";
    }
    
    @RequestMapping("kakaologin")
    public String kakaologin(@RequestParam("code") String code, HttpSession session, ModelMap model) throws Exception {
        System.out.println(this.getClass().getName() + ".kakaologin start!");
        System.out.println("code: " + code);

        String access_token = kakao.getAccessToken(code);
        System.out.println("controller access_token: " + access_token);

        HashMap<String, Object> userInfo = kakao.getUserInfo(access_token);
        
        System.out.println("kakaologin controller : " + userInfo);
        
        if (userInfo.get("email") != null) {
        session.setAttribute("user_name", userInfo.get("nickname"));
        session.setAttribute("user_mail", userInfo.get("email"));
        session.setAttribute("user_range", userInfo.get("age_range"));
        session.setAttribute("user_profile_image", userInfo.get("profile_image_url"));
        session.setAttribute("user_thumbnail_image", userInfo.get("thumbnail_image_url"));
        }
        System.out.println(this.getClass().getName() + ".kakaologin end!");

        model.addAttribute("msg", "로그인 되었습니다!  \"" + session.getAttribute("user_name") + "\"님 환영합니다.");
       	model.addAttribute("url", "/DExellent/index.do");
        
        return "/Redirect";
    }
    
    @RequestMapping(value="kakaologout")
    public String kakaologout(ModelMap model, HttpSession session) throws Exception {
    	
    	session.invalidate();
       	model.addAttribute("msg", "로그아웃 되었습니다.");
       	model.addAttribute("url", "/DExellent/index.do");
       	
       	return "/Redirect";

    }
    
}