<%--
 * Copyright (c) Jean Gabriel Nguema Ngomo.  All rights reserved.  U.S. 
 *'
--%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path=request.getContextPath()+"/exp/home";
	
	String sessioncode = (String) request.getAttribute("sessioncode");

	session.setAttribute("sessioncode",sessioncode) ;
	
	response.sendRedirect(path);
%>

