package com.board.practice2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.practice2.DTO.BoardDTO;
import com.board.practice2.Service.BoardService;

public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/writePost")
	public String writePost() throws Exception {
		
		return "writePost";
	}
	
	@RequestMapping(value="/submitPost")
	public String submitPost(BoardDTO boardDTO) throws Exception {
		
		boardService.submitPost(boardDTO);
		
		return "redirect:/";
	}
}
