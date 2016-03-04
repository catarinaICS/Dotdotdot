package com.seedrs.challenge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * Access the main page
	 * @return The main page template
	 */
	@RequestMapping(value="/challenge")
	public String main(){
		return "dotdotdot";
	}
}
