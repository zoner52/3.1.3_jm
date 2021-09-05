package com.crud.springboot.controller;

import com.crud.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.crud.springboot.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("userInfo")
	public String showAllUsers(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("message", "You are logged in as " + principal.getName());
		model.addAttribute("userInfo", user);
		return "user-data";
	}



}
