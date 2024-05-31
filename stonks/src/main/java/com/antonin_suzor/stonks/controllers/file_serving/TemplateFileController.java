package com.antonin_suzor.stonks.controllers.file_serving;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.antonin_suzor.stonks.models.AccountModel;

@Controller
public class TemplateFileController {
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("accounts", AccountModel.all);
		return "about";
	}

	@GetMapping("/game")
	public String game(Model model) {
		return "game";
	}

	@GetMapping("/user/{id}")
	public String userpage(@PathVariable String id, Model model) {
		AccountModel user = AccountModel.findById(id);
		model.addAttribute("username", user.username);
        model.addAttribute("id", user.id);
		return "userpage";
	}
}
