package com.gura.boot07.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * 	안드로이드의 app 의 요청을 처리할 컨트롤러
 */
@Controller
public class AndroidController {
	/*
	 * JSON 문자열 응답하기
	 * 
	 * 1. @ResponseBody 어노테이션
	 * 2. Map 혹은 List 혹은 Dto 를 리턴하면 자동으로 JSON 문자열로 변환 되어서 응답된다.
	 */
	@RequestMapping("/api/send")
	@ResponseBody
	public Map<String, Object> send(String msg){
		System.out.println(msg);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		map.put("response", "hello client!");
		map.put("num", 1);
		return map;
	}

}
