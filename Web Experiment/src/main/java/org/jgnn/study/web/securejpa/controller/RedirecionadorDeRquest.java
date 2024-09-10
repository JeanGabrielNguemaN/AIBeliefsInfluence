package org.jgnn.study.web.securejpa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirecionadorDeRquest {

	/**
	 * Redirecionar para uma url da aplicação
	 * @param relativeURL 
	 * @param request
	 * @param response
	 */
	public static void redirecionar(String relativeURL, HttpServletRequest request, HttpServletResponse response) {
		try {
				   
			//redirecionar	
				   
			response.sendRedirect( request.getContextPath()+relativeURL);	   
				
		} catch (IOException e) {
							
			e.printStackTrace();	
		}
	}
}
