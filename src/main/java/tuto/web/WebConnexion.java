package tuto.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class WebConnexion {
	
 @GetMapping( "/bonjour" )
	 public String bonjour() {
	 return "bonjour";
	 }
}
