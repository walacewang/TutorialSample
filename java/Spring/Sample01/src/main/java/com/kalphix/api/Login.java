package com.kalphix.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kalphix.biz.login.LoginDto;

/**
 * 
 * @author kalphix
 *
 */
@Controller
public class Login {

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String init() {
		return "login";
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(Model model,  HttpServletResponse response, @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result) {
		String status="401";
		if("WEAAPI".equals(loginDto.getUsername())){
			status="200";
			
			response.addCookie(new Cookie("wea.auth", "XXXXXX"));
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		
		status="401";
		return new ResponseEntity<String>(status, HttpStatus.UNAUTHORIZED);
	}

}
