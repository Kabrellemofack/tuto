package tuto.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("connected")
public class WebConnexion {

    @GetMapping("/bonjour")
    public String bonjour() {
        return "bonjour"; // Assurez-vous d'avoir un template bonjour.html
    }

    @PostMapping("/connect")
    public String connect(@RequestParam String username, @RequestParam String password, Model model) {
        var sb = new StringBuilder(username);

        if (sb.reverse().toString().equals(password)) {
            model.addAttribute("connected", username);
            return "redirect:/bonjour"; // Redirige vers bonjour après une connexion réussie
        } else {
            model.addAttribute("alert", "Mot de passe incorrect");
            model.addAttribute( "username",username );
            model.addAttribute( "password",password );
            return "index"; // Assurez-vous d'avoir un template index.html
        }
    }

    @PostMapping("/disconnect")
    public String disconnect(SessionStatus status, Model model,RedirectAttributes ra ) {
        status.setComplete();
        ra.addFlashAttribute("alert", "Déconnexion effectuée avec succès" );
        return "redirect:/"; // Redirige vers la racine ou vers index.html si nécessaire
    }
}