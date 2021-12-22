package com.board.practice2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.practice2.DAO.BoardDAO;
import com.board.practice2.DTO.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardDTO> boardList() throws Exception {
		
		return boardDAO.boardList();
	}

	@Override
	public void submitPost(BoardDTO boardDTO) {
		boardDAO.submitPost(boardDTO);
		
	}

	@Override
	public BoardDTO readPost(int postNum) {
		return boardDAO.readPost(postNum);
	}

	@Override
	public void plusViewCount(int postNum) {
		boardDAO.plusViewCount(postNum);
	}

	@Override
	public void deletePost(int postNum) {
		boardDAO.deletePost(postNum);
		
	}

	@Override
	public void submitModifyPost(BoardDTO boardDTO) {
		boardDAO.submitModifyPost(boardDTO);
	}
	
}
