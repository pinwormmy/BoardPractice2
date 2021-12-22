package com.board.practice2.DAO;

import java.util.List;

import com.board.practice2.DTO.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> boardList() throws Exception;

	void submitPost(BoardDTO boardDTO);

	BoardDTO readPost(int postNum);

	void plusViewCount(int postNum);

	void deletePost(int postNum);

	void submitModifyPost(BoardDTO boardDTO);
}
