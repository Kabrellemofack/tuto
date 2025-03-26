package tuto.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class WebConnexion {
	
 @GetMapping( "/bonjour" )
	 public String bonjour() {
	 return "bonjour";
	 }
 @GetMapping( "/connect" )
 public String connect(String username,String password,Model model) {
	 var sb = new StringBuilder(username);
	 if(sb.reverse().toString().equals( password )) {
		 model.addAttribute( "connected", username );
		 return "bonjour"; 
	 }else {
		 model.addAttribute( "alert","Mot de passe incorrect" );
		 return "index";
	 }
	 
	 
	 
 }
}
