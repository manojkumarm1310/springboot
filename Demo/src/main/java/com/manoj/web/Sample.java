package com.manoj.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Sample extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		
//		
//		PrintWriter out=res.getWriter();
//		out.print(num1+num2);
		int total=num1+num2+2;
//		req.setAttribute("total",total);
//		
//		RequestDispatcher rd=req.getRequestDispatcher("square");
//		rd.forward(req,res);
		
		
//		HttpSession session=req.getSession();
//		session.setAttribute("total", total);
//		session.setAttribute("string", "I am Manoj");
		
		Cookie cookie=new Cookie("total",total+"");
		res.addCookie(cookie);
		res.sendRedirect("square");
	}
}
