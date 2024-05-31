package com.antonin_suzor.stonks.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonin_suzor.stonks.models.AccountModel;

@RestController
@RequestMapping("/api/users")
public class UsersRestAPI {
	@GetMapping("/{id}")
	public AccountModel getUser(@PathVariable String id) {
		return AccountModel.findById(id);
	}
	@PostMapping("/create")
	public AccountModel postUser(@RequestParam(value = "username") String username) {
		return new AccountModel(username);
	}
}
