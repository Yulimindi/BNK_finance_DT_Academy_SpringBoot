package com.example.rest.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.Member;

@CrossOrigin("http://127.0.0.1:5502") // 모두에게 개방함
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	// http://localhost:8080/api/v1/get-api/hello
	@GetMapping("/hello")
//	@RequestMapping(value = "/hello", method= RequestMethod.GET)
	public String getHello() {
		return "hello";
	}
	
	// http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping("/request1")
	public String getApi(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("organization") String organization) {
		return "이름 : " + name + " 이메일 : " + email + " 회사 : " + organization;
	}
	
	// http://localhost:8080/api/v1/get-api/request2/{variable}
	@GetMapping("/request2/{variable}")
	public String getApi2(@PathVariable("variable") String variable) {
		return "받은 값 : " + variable;
	}
	
	// http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping("/request3")
	public String getParamMap(@RequestParam Map<String, String> param) {
//		String text = "";
//		
//		for(String pp : param.keySet()) {
//			text += pp + " " + param.get(pp);
//		}
//
//		return text;
		
		StringBuilder sb = new StringBuilder(); // 가변객체
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	// http://localhost:8080/api/v1/get-api/request4?name=value1&email=value2&organization=value3
	@GetMapping("/request4")
	public String getApi3(Member m) {
		return "이름 : " + m.getName() + " 이메일 : " + m.getEmail() + " 회사 : " + m.getOrganization();
	}
	
	
}
