package com.ssafy.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.UploadDataVO;

@Controller
public class UploadController {

	@RequestMapping("fileUpload.do")
	public ModelAndView fileUpload(HttpServletRequest request, HttpServletResponse response, UploadDataVO vo) throws Exception{
		
		//1. 업로드된 파일을 받아온다..
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile : "+mFile);
		
		//2. 업로드된 파일이 있다면 파일의 사이즈, 이름을 출력
		if(!mFile.isEmpty()) {
			//업로드된 파일이 있다면
			System.out.println("파일의 사이즈 : "+mFile.getSize());
			System.out.println("파일의 이름 : "+mFile.getOriginalFilename());
		}
		
		//3. 업로드된 파일을 별도의 경로로 이동
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);
		System.out.println("path : "+path);
		
		return new ModelAndView("upload_result","uploadfile", mFile.getOriginalFilename());
	}
	
}
