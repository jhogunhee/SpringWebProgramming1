package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.common.util.CommonUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("study")
public class StudyController {
	
	@GetMapping("getMessage1")
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
	public Map getMessage2() {
		log.info(" :: Study.getMessage2 :: ");
		
		Map map = new HashMap<>();
		map.put("name", CommonUtil.getSelect());
		
		return map;
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
