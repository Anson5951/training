package com.example.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ViewController {

	@GetMapping("index")
	public String homePage() {
		
		
		return "homePageJavaScriptOnly";
	}
	
	@GetMapping("index2")
	public String homePage2() {
		
		
		return "homePage";
	}
}
