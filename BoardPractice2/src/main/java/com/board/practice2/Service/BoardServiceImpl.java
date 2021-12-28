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
	public void submitPost(BoardDTO boardDTO) throws Exception {
		boardDAO.submitPost(boardDTO);
		
	}

	@Override
	public BoardDTO readPost(int postNum) throws Exception {
		return boardDAO.readPost(postNum);
	}

	@Override
	public void plusViewCount(int postNum) throws Exception {
		boardDAO.plusViewCount(postNum);
	}

	@Override
	public void deletePost(int postNum) throws Exception {
		boardDAO.deletePost(postNum);
		
	}

	@Override
	public void submitModifyPost(BoardDTO boardDTO) throws Exception {
		boardDAO.submitModifyPost(boardDTO);
	}

	@Override
	public List<BoardDTO> readComment(int postNum) throws Exception {
		
		return boardDAO.readComment(postNum);
	}

	@Override
	public void submitComment(BoardDTO boardDTO) throws Exception {
		boardDAO.submitComment(boardDTO);
	}

	@Override
	public void deleteComment(int commentNum) throws Exception {
		boardDAO.deleteComment(commentNum);		
	}

	@Override
	public void updateCommentCount(int postNum) throws Exception {
		boardDAO.updateCommentCount(postNum);
	}

	@Override
	public List<BoardDTO> searchList(String searchOption, String searchKeyword) throws Exception {
		return boardDAO.searchList(searchOption, searchKeyword);
	}

	@Override
	public void signUp(BoardDTO boardDTO) throws Exception {
		boardDAO.signUp(boardDTO);
	}

	@Override
	public BoardDTO login(BoardDTO boardDTO) throws Exception {
		
		return boardDAO.login(boardDTO);
	}
	
}
