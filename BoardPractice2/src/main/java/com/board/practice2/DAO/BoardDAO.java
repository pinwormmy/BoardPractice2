package com.board.practice2.DAO;

import java.util.List;

import com.board.practice2.DTO.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> boardList() throws Exception;

	void submitPost(BoardDTO boardDTO) throws Exception;

	BoardDTO readPost(int postNum) throws Exception;

	void plusViewCount(int postNum) throws Exception;

	void deletePost(int postNum) throws Exception;

	void submitModifyPost(BoardDTO boardDTO) throws Exception;

	List<BoardDTO> readComment(int postNum) throws Exception;

	void submitComment(BoardDTO boardDTO) throws Exception;

	void deleteComment(int commentNum) throws Exception;

	void updateCommentCount(int postNum) throws Exception;

	List<BoardDTO> searchList(String searchOption, String saerchKeyword) throws Exception;

	void signUp(BoardDTO boardDTO) throws Exception;

	BoardDTO login(BoardDTO boardDTO) throws Exception;
}
