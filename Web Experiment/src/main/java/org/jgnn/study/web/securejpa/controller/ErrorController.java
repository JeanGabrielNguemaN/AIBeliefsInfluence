package org.jgnn.study.web.securejpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        
        ModelAndView errorPage = new ModelAndView("errors/httpError");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "HTTP 400: Bad Request";
                break;
            }
            case 401: {
                errorMsg = "HTTP 401: Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "HTTP 404: Página inexistente!";
                break;
            }
            case 500: {
                errorMsg = "HTTP 500: Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
    
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}