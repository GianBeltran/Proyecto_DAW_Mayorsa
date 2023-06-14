package com.pe.cibertec.mayorsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home1Controller {
	@GetMapping("/home1")
	public String home1() {
		return "home1";
	}
}
