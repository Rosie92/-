package poly.persistance.mapper;

import java.util.HashMap;
import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;
import poly.dto.CommentDTO;

@Mapper("BoardMapper")
public interface BoardMapper {

	//----------------------------게시판-----------------------------
	int TotalCount() throws Exception;

	List<BoardDTO> getBoardList(HashMap<String, Integer> hMap);

	int InsertBoardWriteProc(BoardDTO bDTO) throws Exception;

	BoardDTO getBoardDetail(String seq) throws Exception;
	
	
	
	
	
	//-----------------------------댓글-----------------------------------
	List<CommentDTO> readReply(String seq) throws Exception;
	int InsertComment(CommentDTO bDTO) throws Exception;
	
	
	
	/*
	
	BoardDTO BoardModifyCertify(BoardDTO pDTO) throws Exception; //수정인증

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
