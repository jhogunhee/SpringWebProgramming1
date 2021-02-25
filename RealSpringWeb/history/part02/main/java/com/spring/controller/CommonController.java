package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("common")
@RestController
public class CommonController {
	
	@GetMapping("getCodeList")
	public Map getCodeList(String upcd) {
		List<Map<String, Object>> masterList = new ArrayList<>(); // 기본 정보 목록
		List<Map<String, Object>> periodList = new ArrayList<>(); // 기간 목록
		List<Map<String, Object>> gradeList  = new ArrayList<>(); // 직급 목록
		
		Map<String, Object> result = new HashMap<>();
		
		// period 기간
		Map<String, Object>
		map = new HashMap<>(); map.put("CODE", "1d"); map.put("VALUE", "1일"); periodList.add(map);
		map = new HashMap<>(); map.put("CODE", "1w"); map.put("VALUE", "1주"); periodList.add(map);
		map = new HashMap<>(); map.put("CODE", "1m"); map.put("VALUE", "1개월"); periodList.add(map);
		map = new HashMap<>(); map.put("CODE", "6m"); map.put("VALUE", "6개월"); periodList.add(map);
		map = new HashMap<>(); map.put("CODE", "1y"); map.put("VALUE", "1년"); periodList.add(map);
		
		// grade 직급
		map = new HashMap<>(); map.put("CODE", "01"); map.put("VALUE", "수습사원"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "02"); map.put("VALUE", "사원"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "03"); map.put("VALUE", "대리"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "04"); map.put("VALUE", "과장"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "05"); map.put("VALUE", "차장"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "06"); map.put("VALUE", "부장"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "07"); map.put("VALUE", "이사"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "08"); map.put("VALUE", "상무"); gradeList.add(map);
		map = new HashMap<>(); map.put("CODE", "09"); map.put("VALUE", "사장"); gradeList.add(map);
		
		// Master 정보
		map = new HashMap<>(); map.put("CODE", "period"); map.put("VALUE", "기간"); masterList.add(map);
		map = new HashMap<>(); map.put("CODE", "grade"); map.put("VALUE", "직급"); masterList.add(map);
		log.info("upcd :: " + upcd);
		if(upcd.equals("period")) {
			result.put("codeList", periodList);
		} else if(upcd.equals("grade")) {
			result.put("codeList", gradeList);
		} else {
			result.put("codeList", masterList);
		}
		
		return result;
	}
}
