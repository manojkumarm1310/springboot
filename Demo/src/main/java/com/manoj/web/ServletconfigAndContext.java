package com.manoj.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletconfigAndContext extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		out.print("Hi ");
//		ServletContext con=req.getServletContext();
//		String name=con.getInitParameter("name");
//		String dept=con.getInitParameter("Department");
		
		
		ServletConfig config=getServletConfig();
		String name=config.getInitParameter("name");
		out.print(name);
	}
}
