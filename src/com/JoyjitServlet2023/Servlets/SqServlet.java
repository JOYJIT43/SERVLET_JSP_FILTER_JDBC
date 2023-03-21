package com.JoyjitServlet2023.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sq")
//if you use Above annotation you don't need web.xml file
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
	  //LIKE THIS we are getting the data passed by the other servlet through request dispatcher
	  //also check web.xml <second>
	   int k=(int) (req.getAttribute("k"));
	   
	  //sendredirect()
	  //this is how we receive and enter values from another servlet that is trying to communicate and send values
	  //this is how we take input from URL , as doGet method takes it's input from query Parameter
//	   int k= Integer.parseInt( req.getParameter("k"));
		
	   k=k*k;
	   
	   PrintWriter write=res.getWriter();
	   
	   write.print("The Square root of the sum of the 2 numbers that were sent to the add Servlet and later"
	   		+ " was sent to this servlet by calling REQ DISPATCHER is "+k);
	   
	   
	}
	
}
