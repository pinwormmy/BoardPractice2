package com.board.practice2.Service;

import java.util.List;

import com.board.practice2.DTO.BoardDTO;

public interface BoardService {
	
	List<BoardDTO> boardList() throws Exception;

	void submitPost(BoardDTO boardDTO);

	BoardDTO readPost(int postNum);

	void plusViewCount(int postNum);

	void deletePost(int postNum);

	void submitModifyPost(BoardDTO boardDTO);

	List<BoardDTO> readComment(int postNum);

	void submitComment(BoardDTO boardDTO);

	void deleteComment(int commentNum);

	void updateCommentCount(int postNum);

	List<BoardDTO> searchList(String searchOption, String saerchKeyword) throws Exception;
}
