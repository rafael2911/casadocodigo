package br.com.alura.spring.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value= {"", "/", "/index"})
	public String index() {
		return "redirect:/produto/";
	}
	
}
