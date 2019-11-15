package com.ssafy.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.Board;
import com.ssafy.board.BoardService;
import com.ssafy.board.UploadDataVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("boardInput.do")
	public ModelAndView boardInput(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInput.do method in");
		return new ModelAndView("redirect:board/boardInsert.jsp");
	}

	@RequestMapping("boardInsert.do")
	public ModelAndView boardInsert(HttpServletRequest request, HttpServletResponse response, Board vo, UploadDataVO dvo)
			throws Exception {
		
		MultipartFile mFile = dvo.getUploadFile();
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\resources\\upload\\";
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);
		
		
		System.out.println("boardInsert.do method in");
		boardService.insert(vo);//
		System.out.println(request.getContextPath());
		return new ModelAndView("redirect:boardList.do");
	}

	@RequestMapping("boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("boardList.do method in");
		List<Board> list = boardService.selectAll();
		for (Board b : list) {
			System.out.println(b);
		}
		return new ModelAndView("boardList", "list", list);
	}

	@RequestMapping("boardDetail.do")
	public ModelAndView boardDetail(HttpServletRequest request, HttpServletResponse response, Board vo) throws Exception {
		System.out.println("boardDetail.do method in");
		Board rvo = boardService.selectOne(vo.getNo()+"");

		return new ModelAndView("boardDetail", "vo", rvo);
	}
}
