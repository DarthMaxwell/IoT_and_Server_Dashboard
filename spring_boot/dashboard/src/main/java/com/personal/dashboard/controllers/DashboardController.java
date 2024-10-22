package com.personal.dashboard.controllers;

import java.io.IOException;
import java.net.UnknownHostException;

import com.personal.dashboard.services.PingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@Autowired private PingService ps;

	@GetMapping("/")
	public String showDashboard(Model model) throws UnknownHostException, IOException {
		// If logged in then show dashboard else
		boolean[] ping = ps.ping();
		String host1Ping = (ping[0]) ? "Host alive" : "Host dead";
		String host2Ping = (ping[1]) ? "Host alive" : "Host dead";
		
		model.addAttribute("Host1", host1Ping);
		model.addAttribute("Host2", host2Ping);
		
		// add rediect later
		return "dashboard";
	}
}
