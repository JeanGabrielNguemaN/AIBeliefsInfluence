package org.jgnn.study.web.securejpa.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class RespostaController
{
    
    
    
    
    @RequestMapping(value="/resposta", method = RequestMethod.GET)
    public String formresposta(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){   
        	
           String principal = auth.getName();
           
           model.addAttribute("principal", principal);
           
        }
        return "formresposta";
    }
    
    @RequestMapping(value="/resposta/add", method = RequestMethod.GET)
    public String respostacad(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){   
        	
           String principal = auth.getName();
           
           model.addAttribute("principal", principal);
           
        }
        return "resposta";
    }
}
