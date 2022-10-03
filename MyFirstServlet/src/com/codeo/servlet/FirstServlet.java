package com.codeo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitValue1")
public class FirstServlet extends HttpServlet {
	
	String name=null;
	String email=null;
	String mobileno=null;
	String lastname=null;
	String gender=null;
	String subject=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("name");
		lastname=request.getParameter("lastname");
		email=request.getParameter("email");
		mobileno=request.getParameter("mobileno");
		gender=request.getParameter("gender");
		subject=request.getParameter("subject");
		
		FirstServletDao fsd=new FirstServletDao();
		fsd.submitData(name,lastname,email,mobileno,gender,subject);
		
	}

}
