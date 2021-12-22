package com.board.practice2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.practice2.DTO.BoardDTO;
import com.board.practice2.Service.BoardService;

@Controller
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
	
	@RequestMapping(value="/readPost")
	public String readPost(Model model, int postNum) throws Exception {
		
		BoardDTO readPost = boardService.readPost(postNum);
		model.addAttribute("readPost", readPost);
		
		boardService.plusViewCount(postNum);
		
		return "readPost";
	}
	
	@RequestMapping(value="/deletePost")
	public String deletePost(int postNum) throws Exception {
		
		boardService.deletePost(postNum);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/modifyPost")
	public String modifyPost(Model model, int postNum) throws Exception {
		
		BoardDTO readPost = boardService.readPost(postNum);
		model.addAttribute("readPost", readPost);
		
		return "modifyPost";
	}
	
	@RequestMapping(value="/submitModifyPost")
	public String submitModifyPost(BoardDTO boardDTO) throws Exception {
		
		boardService.submitModifyPost(boardDTO);
		
		return "redirect:/readPost?postNum=" + boardDTO.getPostNum();
	}
}
