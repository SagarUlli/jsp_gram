package org.jsp.jsp_gram.controller;

import org.jsp.jsp_gram.dto.Post;
import org.jsp.jsp_gram.dto.User;
import org.jsp.jsp_gram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {
	@Autowired
	UserService service;

	@GetMapping({ "/", "/login" })
	public String loadLogin() {
		return "login.html";
	}

	@GetMapping("/register")
	public String loadRegister(ModelMap map, User user) {
		return service.loadRegister(map, user);
	}

	@PostMapping("/register")
	public String register(@Valid User user, BindingResult result, HttpSession session) {
		return service.register(user, result, session);
	}

	@GetMapping("/otp/{id}")
	public String loadOtpPage(@PathVariable int id, ModelMap map) {
		map.put("id", id);
		return "user-otp.html";
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, HttpSession session) {
		return service.verifyOtp(id, otp, session);
	}

	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id, HttpSession session) {
		return service.resendOtp(id, session);
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, String password, HttpSession session) {
		return service.login(username, password, session);
	}

	@GetMapping("/home")
	public String loadHome(HttpSession session) {
		return service.loadHome(session);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return service.logout(session);
	}

	@GetMapping("/profile")
	public String loadProfile(HttpSession session, ModelMap map) {
		return service.profile(session, map);
	}

	@GetMapping("/edit-profile")
	public String editProfile(HttpSession session) {
		return service.editProfile(session);
	}

	@PostMapping("/update-profile")
	public String updateProfile(@RequestParam MultipartFile image, @RequestParam String bio, HttpSession session) {
		return service.updateProfile(image, session, bio);
	}

	@GetMapping("/addpost")
	public String loadAddPost(ModelMap map, HttpSession session) {
		return service.loadAddPost(map, session);
	}

	@PostMapping("/addpost")
	public String addPost(Post post, HttpSession session) {
		return service.addPost(post, session);
	}

	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable int id, HttpSession session) {
		return service.deletePost(id, session);
	}

	@GetMapping("/edit-post/{id}")
	public String editPost(HttpSession session, @PathVariable int id, ModelMap map) {
		return service.editPost(session, id, map);
	}

	@PostMapping("/update-post")
	public String updatePost(Post post, HttpSession session) {
		return service.updatePost(post, session);
	}
}