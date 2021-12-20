package com.board.practice2.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.practice2.DTO.BoardDTO;
import com.board.practice2.Service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		List<BoardDTO> boardList = null;
		boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
				
		return "home";
	}
	
}
