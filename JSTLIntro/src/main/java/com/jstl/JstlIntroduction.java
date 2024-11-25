package com.jstl;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JstlIntroduction extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("Value", 10);
		
		RequestDispatcher rd=req.getRequestDispatcher("jstl.jsp");
		rd.forward(req, res);
		
		
	}

}
