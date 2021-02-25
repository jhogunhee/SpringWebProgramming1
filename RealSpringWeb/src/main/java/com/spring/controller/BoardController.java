package com.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("writeForm2")
	public String writeForm2(Model model, HttpServletRequest req, HttpServletResponse res) {
		return "board/writeForm2";
	}
	
	@PostMapping("upload2")
	@ResponseBody
	public Map upload2(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		String sPath = "";
		
		List<MultipartFile> files = req.getFiles("files");
		List<String> result = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		try {
			for (MultipartFile mpf : files) {
				
				result.add(mpf.getOriginalFilename());
				sPath = "c:" + File.separator + "NAS" + File.separator;

				File chkDir = new File(sPath);

				if(!chkDir.isDirectory()) {
					chkDir.mkdirs();
				}

				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(sPath + mpf.getOriginalFilename()));
			}
			map.put("files", result);
		} catch(IOException e) {
			System.out.println("error - " + e.getMessage());
			e.printStackTrace();
		}
//		System.out.println(result);
//		System.out.println(map);
		
		return map;
	}
	
	@RequestMapping("getFileDownload")
	public ModelAndView getFileDownload(@RequestParam Map<String, Object> map) throws Exception {
		String path = "c:" + File.separator + "NAS" + File.separator + map.get("filename");
		File downloadFile = new File(path);
		
//		new ModelAndView(viewName, modelName, modelObject)
		// view 이름,  model 이름, 파일 객체
		return new ModelAndView("downloadView", "downloadFile", downloadFile);
	}
}
