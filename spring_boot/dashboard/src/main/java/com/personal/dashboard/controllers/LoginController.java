package com.personal.dashboard.controllers;

import com.personal.dashboard.services.PasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired private PasswordService ps;

	@GetMapping
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping
	public String checkLogin(@RequestParam String username,
			@RequestParam String password,
			HttpServletRequest request,
			RedirectAttributes ra) {
		
		if (!ps.checkLogin(username, password)) {
			ra.addFlashAttribute("msg", "Username or Password incorrect");
			return "redirect:login";
		}
		
		request.getSession().invalidate();
		HttpSession ses = request.getSession();
		ses.setMaxInactiveInterval(3600); // 1 hour
		ses.setAttribute("admin", "admin");
		
		return "redirect:";
	}
}
