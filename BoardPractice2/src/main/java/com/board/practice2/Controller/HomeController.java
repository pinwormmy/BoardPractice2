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
		
		int postLimit = 25;
		int pageLimit = 10;
		int pageNum = 1;
		int postEndNum = pageNum * postLimit - 1;
		int postStartNum = postEndNum - (postLimit - 1);
		int pageStartNum = ((int)Math.ceil((float)pageNum / pageLimit) -1) * pageLimit + 1;
		int pageEndNum = pageStartNum + (pageLimit - 1);
		int pageMaxNum = (int) Math.ceil((float)boardList.size() / postLimit);
		if(pageEndNum > pageMaxNum)
			pageEndNum = pageMaxNum;
		
		model.addAttribute("postStartNum", postStartNum);
		model.addAttribute("postEndNum", postEndNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("pageEndNum", pageEndNum);
		model.addAttribute("pageCurrentNum", pageNum);
		model.addAttribute("pageMaxNum", pageMaxNum);
				
		return "home";
	}
	
}
