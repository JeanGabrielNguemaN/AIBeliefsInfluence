package org.jgnn.study.web.securejpa.controller;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController implements ErrorController{

	 @GetMapping("error")
	 public String error(HttpServletRequest request,Model model){
		   
		 
		    
		   Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		    
		   if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		    
		        if(statusCode == HttpStatus.FORBIDDEN.value()) {
		            model.addAttribute("errorMessage","You don't have access to this page.");
		        }
		        

		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		        	model.addAttribute("errorMessage","This page is not available.");
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		        	model.addAttribute("errorMessage","Some problem occurs...");
		        }
		    }
		   
		   return "errors/error";
	}
	 
	 
	 @GetMapping("errorOld")
	 public String errorOld(HttpServletRequest request,Model model){
		   
		   Principal userPrincipal = request.getUserPrincipal();
		   
		   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   
		   Collection<? extends GrantedAuthority> autorities = auth.getAuthorities();
		   
		  
		   System.out.println("User: "
				   +userPrincipal.getName() +" *** Role: ");
		   
		   autorities.stream().forEach(a->System.out.println("ROLE = "+a.getAuthority()));
		   
		    
		   Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		    
		   if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		    
		        if(statusCode == HttpStatus.FORBIDDEN.value()) {
		            model.addAttribute("errorMessage","You don't have access to this page.");
		        }
		        

		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		        	model.addAttribute("errorMessage","This page is not available.");
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		        	model.addAttribute("errorMessage","Some problem occurs...");
		        }
		    }
		   
		   return "errors/error";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "null";
	}
}
