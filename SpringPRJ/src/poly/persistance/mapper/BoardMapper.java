package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;
import poly.dto.CommentDTO;

@Mapper("BoardMapper")
public interface BoardMapper {

	//----------------------------게시판-----------------------------
	// 게시판 총 게시글 수 확인하기
	int TotalCount() throws Exception;
	// 게시판 리스트 불러오기
	List<BoardDTO> getBoardList(HashMap<String, Integer> hMap);
	// 게사판 글 작성 실행하기
	int InsertBoardWriteProc(BoardDTO bDTO) throws Exception;
	// 게시판 글 디테일 실행하기
	BoardDTO getBoardDetail(String seq) throws Exception;
	// 게시판 글 수정/삭제 이동 전 권한 확인하기
	String UserCheck(String board_seq) throws Exception;
	// 게시판 글 수정/삭제 창으로 이동하기
	BoardDTO BoardReWrite(BoardDTO pDTO) throws Exception;
	
	
	
	
	
	//-----------------------------댓글-----------------------------------
	// 댓글 리스트 불러오기
	List<CommentDTO> readReply(String seq) throws Exception;
	// 댓글 작성 실행하기
	int InsertComment(CommentDTO bDTO) throws Exception;
	
	
	
	/*
	
	

	BoardDTO GUI2(BoardDTO pDTO) throws Exception;
		
	BoardDTO BoardModifyCertify2(BoardDTO pDTO) throws Exception;
		
	int BoardUpdate(BoardDTO pDTO) throws Exception;
		
	BoardDTO BoardModify(BoardDTO pDTO) throws Exception;
		
	BoardDTO GUI3(BoardDTO pDTO) throws Exception;
		
	int BoardDelete(BoardDTO pDTO) throws Exception;
	
	
	*/
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * String checkId(BMUserInfoDTO pDTO) throws Exception; int
	 * UserDelete(BMUserInfoDTO pDTO) throws Exception;
	 * 
	 * BoardDTO GUI4(BoardDTO pDTO) throws Exception;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * COMMENTDTO CommentModifyTry(COMMENTDTO pDTO) throws Exception;
	 * 
	 * int CommentCertify(COMMENTDTO pDTO) throws Exception;
	 * 
	 * COMMENTDTO CommentCertify2(COMMENTDTO pDTO) throws Exception;
	 * 
	 * int CommentUpdate(COMMENTDTO pDTO) throws Exception;
	 * 
	 * int CommentDelete(COMMENTDTO pDTO) throws Exception;
	 * 
	 * COMMENTDTO selectRe(COMMENTDTO pDTO) throws Exception;
	 */

}
