package com.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.CopyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {
	
	@GetMapping("writeForm1")
	public String writeForm1(Model model, HttpServletRequest req, HttpServletResponse res) {
		return "board/writeForm1";
	}
	
	@PostMapping("upload")
	public String upload(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		String sPath = "";
		
		List<MultipartFile> files = req.getFiles("files");
		
		try {
			for (MultipartFile mpf : files) {

				sPath = "c:" + File.separator + "NAS" + File.separator;

				File chkDir = new File(sPath);

				if(!chkDir.isDirectory()) {
					chkDir.mkdirs();
				}

				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(sPath + mpf.getOriginalFilename()));
			}
		} catch(IOException e) {
			System.out.println("error - " + e.getMessage());
			e.printStackTrace();
		}
		
		return "home/registOk";
	}
}
