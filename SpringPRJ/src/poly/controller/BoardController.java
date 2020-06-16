package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.BoardDTO;
import poly.dto.PagingDTO;
import poly.service.IBoardService;
import poly.util.EncryptUtil;

@Controller
public class BoardController {

	private Logger log = Logger.getLogger(this.getClass().getName());

	@Resource(name = "BoardService")
	private IBoardService BoardService;
	
	
	//--------------------------리스트-------------------------
	@RequestMapping(value = "/DExellent/board/BoardList")
	public String BoardList(HttpServletRequest request, Model model) throws Exception {
		log.info(this.getClass().getName() + "########자유게시판 실행########");

		int page = Integer.parseInt(request.getParameter("Pno"));
		int listCnt = BoardService.TotalCount(); // 총 게시글 개수

		log.info("int page : " + page);
		log.info("int listCnt : " + listCnt);

		PagingDTO paging = new PagingDTO();

		paging.pageInfo(page, listCnt);
		HashMap<String, Integer> hMap = new HashMap<>();
		int i = paging.getStartList();
		int j = paging.getListSize();
		hMap.put("startlist", i);
		hMap.put("listsize", i + j);

		List<BoardDTO> bList = new ArrayList<>();

		log.info("bList : " + bList);

		try {
			bList = BoardService.getBoardList(hMap);

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("bList", bList);
		model.addAttribute("paging", paging);

		return "/DExellent/board/BoardList";
	}
	
	
	
	
	
	
	/*
	 
	//----------------------글작성 연결-----------------------
	@RequestMapping(value = "/DExellent/board/BoardWrite")
	public String BoardWrite(HttpSession session, HttpServletRequest request, ModelMap model) throws Exception {
		log.info("######## 자유게시판 글작성 시작 ##############");

		if (session.getAttribute("user_name") == null) {
			model.addAttribute("msg", "로그인 후 다시 시도해주세요");
			model.addAttribute("url", "//DExellent/board/BoardWrite");
			return "/Redirect";

		} else if (session.getAttribute("user_name").equals("조정규")) {
			return "/DExellent/board/BoardWrite";

		} else {
			return "/DExellent/board/BoardWrite";
		}
	}

	
	//------------------------글작성 실행-------------------------
	@RequestMapping(value = "/DExellent/board/BoardWriteProc")
	public String BoardWriteProc(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		log.info(this.getClass().getName() + "########자유게시판 작성Proc 실행########");

		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String user_name = (String) session.getAttribute("SS_USER_ID");

			log.info(title);
			log.info(content);
			log.info(user_name);

			// 여기부터
			BoardDTO bDTO = new BoardDTO();
			bDTO.setTitle(title);
			bDTO.setContent(content);
			bDTO.setUser_name(user_name);

			log.info("========================");
			log.info("title : " + title);
			log.info("content : " + content);
			log.info("user_name : " + user_name);
			log.info("========================");

			int res = 0;

			res = BoardService.insertBoardWriteProc(bDTO);
			log.info("res : " + res);

			if (res > 0) {
				model.addAttribute("url", "/DExellent/board/BoardWriteProc?Pno=1);
				model.addAttribute("msg", "등록되었습니다.");
			} else {
				model.addAttribute("url", "/DExellent/board/BoardWriteProc?Pno=1");
				model.addAttribute("msg", "등록에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 이렇게 변경
		return "/Redirect";
	}
	
	//------------------------디테일 실행----------------------
	@RequestMapping(value = "/DExellent/board/BoardDetail")
	public String BoardDetail(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		log.info(this.getClass().getName() + "########자유게시판 디테일 실행########");

		String seq = request.getParameter("seq");
		
		BoardDTO bDTO = new BoardDTO();
		
		List<CommentDTO> cList = BoardService.readReply(seq);
		
		try {
			bDTO = BoardService.getBoardDetail(seq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("cList", cList);
		model.addAttribute("bDTO", bDTO);
		model.addAttribute("seq", seq);
		return "/DExellent/board/BoardDetail";

	}
	
	//--------------------------글 수정삭제 이동-------------------
	@RequestMapping(value = "/DExellent/board/BoardModifyCertify")
	public String BoardModifyCertify(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		log.info(this.getClass().getName() + "자유게시판 글 수정/삭제창으로 이동");

		String seq = request.getParameter("seq");

		BoardDTO pDTO = new BoardDTO();

		try {
			pDTO = new BoardDTO();
			pDTO.setBoard_seq(seq);
			pDTO = BoardService.ModifyCertify(pDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("seq", seq);

		return "/DExellent/board/BoardModifyCertify";
	}

	
	//--------------------------글 수정 실행---------------------------
	@RequestMapping(value = "/DExellent/board/BoardModify")
	public String BoardModify(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		log.info(this.getClass().getName() + "########자유게시판 글 수정창 실행########");

		String seq = request.getParameter("seq");

		BoardDTO pDTO = new BoardDTO();
		pDTO.setBoard_seq(seq);

		try {
			pDTO = new BoardDTO();
			int res = 0;
			res = BoardService.BoardModify(pDTO);
			log.info("res : " + res);

			if (res == 1) {

				pDTO = BoardService.GUI3(pDTO);

				String title = pDTO.getTitle();
				String content = pDTO.getContent();
				String upd_date = pDTO.getUpd_date();
				String user_id = pDTO.getUser_name();
				String board_seq = pDTO.getBoard_seq();

				log.info("title :" + title);
				log.info("content : " + content);
				log.info("upd_date : " + upd_date);
				log.info("user_id : " + user_id);
				log.info("board_seq : " + board_seq);

				model.addAttribute("pDTO", pDTO);
				return "/DExellent/board/BoardModify";

			} else {
				model.addAttribute("msg", "오류가 발생했습니다. 다시 시도해주세요");
				model.addAttribute("url", "/DExellent/board/BoardList.do?Pno=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/Redirect";
	}
	
	
	//------------------------글 수정 실행------------------------------
	@RequestMapping(value = "/DExellent/board/BoardModify2")
	public String BoardModify2(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		log.info(this.getClass().getName() + "######## 자유게시판 글 수정하기 실행########");
		String seq = request.getParameter("seq");

		BoardDTO pDTO = new BoardDTO();
		pDTO.setBoard_seq(seq);

		try {
			String title = (String) request.getParameter("title");
			String content = (String) request.getParameter("content");

			log.info("seq : " + seq);
			log.info("title : " + title);
			log.info("content : " + content);

			pDTO.setTitle(title);
			pDTO.setContent(content);

			log.info("========================");
			log.info("Board_seq : " + seq);
			log.info("title : " + title);
			log.info("content : " + content);
			log.info("========================");

			int res = BoardService.BoardUpdate(pDTO);
			log.info("res : " + res);

			if (res > 0) {
				model.addAttribute("url", "/DExellent/board/BoardList.do?Pno=1");
				model.addAttribute("msg", "수정되었습니다.");
			} else {
				model.addAttribute("url", "/DExellent/board/BoardList.do?Pno=1");
				model.addAttribute("msg", "수정에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/Redirect";

	}


	//---------------------------글 삭제 실행-------------------------
	@RequestMapping(value = "/DExellent/board/BoardDelete")
	public String BoardDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		log.info(this.getClass().getName() + "########자유게시판 글 삭제하기 실행########");
		try {
			String seq = request.getParameter("seq");

			BoardDTO pDTO = new BoardDTO();
			pDTO.setBoard_seq(seq);
			log.info("seq : " + seq);

			int res = BoardService.BoardDelete(pDTO);
			log.info("res : " + res);

			if (res > 0) {
				model.addAttribute("url", "/DExellent/board/BoardList.do?Pno=1");
				model.addAttribute("msg", "삭제되었습니다.");
			} else {
				model.addAttribute("url", "/DExellent/board/BoardList.do?Pno=1");
				model.addAttribute("msg", "삭제에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/Redirect";

	}
	
	
	*/
	
	
}
