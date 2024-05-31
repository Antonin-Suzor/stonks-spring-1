package com.antonin_suzor.stonks.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonin_suzor.stonks.entities.AccountEntity;
import com.antonin_suzor.stonks.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersRestAPI {
	@GetMapping("")
	public List<AccountEntity> getAllUsers() {
		return UserService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public AccountEntity getUser(@PathVariable String id) {
		return UserService.findById(id);
	}
	@PostMapping("/create")
	public AccountEntity postUser(@RequestParam(value = "username") String username, @RequestParam(value = "password", required = false) String password) {
		return password != null ? UserService.createUser(username, password) : UserService.createUser(username);
	}
}
