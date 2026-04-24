package com.example.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.rest.dto.Culture;
import com.example.rest.service.MyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MyRestController {
	
	final MyService ms;
	
	@GetMapping("/data")
	public ModelAndView getData() throws IOException {
		ModelAndView mav = new ModelAndView("forward:/view");
		mav.addObject("info", ms.getData());
		return mav;
	}
	
	@GetMapping("/dataForApp")
	public List<Culture> getDataForApp() throws IOException {
		return ms.getData();
	}
	
	@GetMapping("/dataForApp2/{MYONGCHING}")
	public Culture getDataForApp2(@PathVariable("MYONGCHING") String MYONGCHING) throws IOException {
		
		Culture cul = null;
		for(Culture c : ms.getData()) {
			if(c.getMYONGCHING().endsWith(MYONGCHING)) {
				cul = c;
				System.out.println(cul);
			}
		}
		return cul;
	}
}
