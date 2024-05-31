package com.antonin_suzor.stonks.controllers.file_serving;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.antonin_suzor.stonks.dtos.requests.SignUpRequest;
import com.antonin_suzor.stonks.entities.AccountEntity;
import com.antonin_suzor.stonks.services.UserService;

@Controller
public class TemplateFileController {
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("accounts", UserService.getAllUsers());
		return "about";
	}

	@GetMapping("/game")
	public String game(Model model) {
		return "game";
	}

	@GetMapping("/signup")
	public String signupGet(Model model) {
		model.addAttribute("signUpRequest", new SignUpRequest());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@ModelAttribute SignUpRequest request, Model model) {
		return "redirect:/user/" + UserService.createUser(request.getUsername(), request.getPassword()).getId();
	}

	@GetMapping("/user/{id}")
	public String userpage(@PathVariable String id, Model model) {
		AccountEntity user = UserService.findById(id);
		model.addAttribute("username", user.getUsername());
        model.addAttribute("id", user.getId());
		return "userpage";
	}
}
