package poly.service;

import java.util.HashMap;
import java.util.List;

import poly.dto.BoardDTO;
import poly.dto.CommentDTO;

public interface IBoardService {

	
	//---------------------------게시판-------------------------
	int TotalCount() throws Exception;
	
	List<BoardDTO> getBoardList/*BMFreeB*/(HashMap<String, Integer> hMap) throws Exception;

	int InsertBoardWriteProc(BoardDTO bDTO) throws Exception;
	
	BoardDTO getBoardDetail(String seq) throws Exception;
	
	
	
	
	//-----------------------------댓글--------------------------
	List<CommentDTO> readReply(String seq) throws Exception;
	int InsertComment(CommentDTO bDTO) throws Exception;
	
	
	
	
	
	
	/*
	


	
	BoardDTO BoardModifyCertify(BoardDTO pDTO) throws Exception;
	
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
	 * insertCommentSR(COMMENTDTO bDTO) throws Exception; int
	 * insertCommentQT(COMMENTDTO bDTO) throws Exception; int
	 * insertCommentM(COMMENTDTO bDTO) throws Exception;
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
