package com.board.practice2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		List<BoardDTO> readComment = boardService.readComment(postNum);
		model.addAttribute("readComment", readComment);
		
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
	
	@RequestMapping(value = "/page")
	public String home(Model model, int pageNum) throws Exception {
		
		List<BoardDTO> boardList = null;
		boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
		
		int postLimit = 25;
		int pageLimit = 10;
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
