package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.BoardDTO;
import poly.dto.CommentDTO;

public interface IBoardService {

	
	//---------------------------게시판-------------------------
	
	// 총 게시글 수 세기
	int TotalCount() throws Exception;
	// 게시판 리스트 불러오기
	List<BoardDTO> getBoardList(HashMap<String, Integer> hMap) throws Exception;
	// 게시판 글 작성 실행하기
	int InsertBoardWriteProc(BoardDTO bDTO) throws Exception;
	// 게시판 글 디테일 
	BoardDTO getBoardDetail(String seq) throws Exception;
	// 게시판 글 수정/삭제 이동 전 권한 확인하기
	String UserCheck(String board_seq) throws Exception;
	// 게시판 글 수정/삭제 창으로 이동하기
	BoardDTO BoardReWrite(BoardDTO pDTO) throws Exception;
	
	
	
	//-----------------------------댓글--------------------------
	// 댓글 리스트 불러오기
	List<CommentDTO> readReply(String seq) throws Exception;
	// 댓글 작성 실행하기
	int InsertComment(CommentDTO bDTO) throws Exception;




	
	
	
	/*
	


	
	
	
	BoardDTO GUI2(BoardDTO pDTO) throws Exception;
	
	BoardDTO BoardModifyCertify2(BoardDTO pDTO) throws Exception;
	
	int BoardUpdate(BoardDTO pDTO)throws Exception;	
	
	int BoardModify(BoardDTO pDTO) throws Exception;
	
	BoardDTO GUI3(BoardDTO pDTO) throws Exception;
	
	int BoardDelete(BoardDTO pDTO) throws Exception;
	
	BoardDTO GUI4(BoardDTO pDTO) throws Exception;
	
	
	
	*/
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 

	 * 
	 * COMMENTDTO CommentModifyTry(COMMENTDTO pDTO) throws Exception; COMMENTDTO
	 * CommentModifyTrySR(COMMENTDTO pDTO) throws Exception; COMMENTDTO
	 * CommentModifyTryQT(COMMENTDTO pDTO) throws Exception; COMMENTDTO
	 * CommentModifyTryM(COMMENTDTO pDTO) throws Exception;
	 * 
	 * int CommentCertify(COMMENTDTO pDTO) throws Exception; int
	 * CommentCertifySR(COMMENTDTO pDTO) throws Exception; int
	 * CommentCertifyQT(COMMENTDTO pDTO) throws Exception; int
	 * CommentCertifyM(COMMENTDTO pDTO) throws Exception;
	 * 
	 * COMMENTDTO CommentCertify2(COMMENTDTO pDTO)throws Exception; COMMENTDTO
	 * CommentCertify2SR(COMMENTDTO pDTO)throws Exception; COMMENTDTO
	 * CommentCertify2QT(COMMENTDTO pDTO)throws Exception; COMMENTDTO
	 * CommentCertify2M(COMMENTDTO pDTO)throws Exception;
	 * 
	 * int CommentUpdate(COMMENTDTO pDTO) throws Exception; int
	 * CommentUpdateSR(COMMENTDTO pDTO) throws Exception; int
	 * CommentUpdateQT(COMMENTDTO pDTO) throws Exception; int
	 * CommentUpdateM(COMMENTDTO pDTO) throws Exception;
	 * 
	 * int CommentDelete(COMMENTDTO pDTO) throws Exception; int
	 * CommentDeleteSR(COMMENTDTO pDTO) throws Exception; int
	 * CommentDeleteQT(COMMENTDTO pDTO) throws Exception; int
	 * CommentDeleteM(COMMENTDTO pDTO) throws Exception;
	 * 
	 * COMMENTDTO selectRe(COMMENTDTO pDTO) throws Exception; COMMENTDTO
	 * selectReSR(COMMENTDTO pDTO) throws Exception; COMMENTDTO
	 * selectReQT(COMMENTDTO pDTO) throws Exception; COMMENTDTO selectReM(COMMENTDTO
	 * pDTO) throws Exception;
	 */

	

	

	
	
}
