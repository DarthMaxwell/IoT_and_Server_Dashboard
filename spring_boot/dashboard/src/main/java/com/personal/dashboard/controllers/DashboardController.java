package com.personal.dashboard.controllers;

import java.io.IOException;
import java.net.UnknownHostException;

import com.personal.dashboard.services.PingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	@Autowired private PingService ps;
	
	// Static variables
	private final String host1 = "PiHole";
	private final byte[] host1Ip = new byte[] { (byte) 192, (byte) 168, 86, (byte) 163};
	private final int host1Port = 80; // idk if this is the best way to look at this
	
	private final String host2 = "FileSharing";
	private final byte[] host2Ip = new byte[] {(byte) 192, (byte) 168, 86, (byte) 165};
	private final int host2Port = 445;

	@GetMapping("/")
	public String showDashboard(Model model, HttpSession ses) throws UnknownHostException, IOException {
		if (ses != null && ses.getAttribute("admin") != null) { // Valid session
			// Host1
			boolean[] ping = ps.pingIpandPort(host1Ip, 80);
			
			model.addAttribute("host1", host1);
			model.addAttribute("host1Ping", ping[0]);
			model.addAttribute("host1Port", host1Port);
			model.addAttribute("host1PortCon", ping[1]);
			
			// Host2
			ping = ps.pingIpandPort(host2Ip, 445);
			
			model.addAttribute("host2", host2);
			model.addAttribute("host2Ping", ping[0]);
			model.addAttribute("host2Port", host2Port);
			model.addAttribute("host2PortCon", ping[1]);
			
			// Arduino temp sensor
			
			return "dashboard";
		}
		
		return "redirect:login";
	}
}
