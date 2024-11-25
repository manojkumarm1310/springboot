package com.manoj.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SquareSum extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
//		int total=(int)req.getAttribute("total");
		
//		int square=total*total;
//		PrintWriter out=res.getWriter();
//		out.print(square);
		
		
//		int value=Integer.parseInt(req.getParameter("value"));
		
//		HttpSession session=req.getSession();
//		int value= (int)session.getAttribute("total");
		
		
		Cookie cookie[]=req.getCookies();
		int value=0;
		for(Cookie c:cookie) {
			if(c.getName().equals("total")) {
				value=Integer.parseInt(c.getValue());
			}
		}
		
		int square=value*value;
//		String str=(String)session.getAttribute("string");
		PrintWriter out=res.getWriter();
		out.print(square + " hello");
	}

}
