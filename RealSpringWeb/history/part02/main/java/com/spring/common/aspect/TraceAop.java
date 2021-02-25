package com.spring.common.aspect;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TraceAop {

	@Pointcut("execution(public * com.spring.controller..*(..))")
	public void pointCutMethod() {}
	
	@Around("pointCutMethod() && args(model, req, res)")
	public Object trace(ProceedingJoinPoint joinPoint, Model model, 
			HttpServletRequest req, HttpServletResponse res) throws Throwable {
		
	  log.info("========================================================");	
	  log.info("profiler == Before || " + joinPoint.getSignature().toShortString()); // 어떤 메서드를 호출하였는지 출력
	  log.info("== 이 시스템은 " + System.getProperty("spring.profiles.active") + "입니다.");
	  String addr = req.getRemoteAddr();
	  log.info("== 서비스 요청 ip는 " + addr + "입니다.");
	  log.info("========================================================");
	  
	  ObjectMapper oMapper = new ObjectMapper();
	  //파라미터로 날려온 model을 map의 형태로 변환한다.
	  Map<String, Object> map = oMapper.convertValue(joinPoint.getArgs()[0], Map.class); 
	  
	  Object result = new Object();
	  try {
		  result = joinPoint.proceed();
		  
		  map.put("SERVICE"  , req.getServletPath()); // 요청 서비스
		  map.put("ACCESS_IP", addr);				  // 서비스 요청 ip
		  map.put("REQ_QUERY", req.getQueryString()); // 파라미터들 출력
		  System.out.println(map);
		  
		  return result;
	  } finally {
		  
	  }
	}
}
