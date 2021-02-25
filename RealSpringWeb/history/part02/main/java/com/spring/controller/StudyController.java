package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.common.util.CommonUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("study")
public class StudyController {
	
	@GetMapping("getMessage1")
	@ResponseBody
	public User getMessage1() {
		log.info(" :: Study.getMessage1 :: ");
		List list = new ArrayList<>();
		list.add("test");
		list.add("test2");
		Map map = new HashMap<>();
		map.put("key", "object");
		map.put("이름", "건희");
		
		User user = new User("빵형", "1", list, map);
		
		return user;
	}
	
	@GetMapping("getMessage2")
	@ResponseBody
	public Map getMessage2() {
		log.info(" :: Study.getMessage2 :: ");
		
		Map map = new HashMap<>();
		map.put("name", CommonUtil.getSelect());
		
		return map;
	}
	
	@GetMapping("exceptionByZero")
	public Map exceptionByZero() {
		log.info(" :: Study.exceptionByZero :: ");
		System.out.println(1/0);
		return new HashMap<>();
	}
	
	@GetMapping("registForm")
	public String registFrom(Model model, HttpServletRequest req, HttpServletResponse res) {
		return "home/registForm";
	}
	
	@PostMapping("doReg")
	public String doReg(@RequestParam Map<String, Object> map, Model model, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println("Parameter :: " + map.toString());
		return "home/registOk";
	}
}

@Data
@AllArgsConstructor
class User {
	private String name;
	private String no;
	List list;
	Map<String, Object> map;
}
