package com.example.demo.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Inquiry;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Inquiry inquiry) {
		return "index";
	}
	
	@PostMapping("/")
	// @Validated 入力値チェック　結果を BIndingResultに格納 result.hasErrors()でエラーの確認
	public String confirm(@Validated @ModelAttribute Inquiry inquiry, BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		return "confirm";
	}

}
