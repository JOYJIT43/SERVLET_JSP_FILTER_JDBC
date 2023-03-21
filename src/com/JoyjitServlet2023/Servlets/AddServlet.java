package com.JoyjitServlet2023.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//create a random class and extend HttpServlet and it becomes a servlet
//if you use below annotation you don't need web.xml file
@WebServlet("/add")
public class AddServlet extends HttpServlet{
	
	//All logic should be written inside the service class only
	//also if you make the method name as doPost or doGet it'll only accept POST and GET request explicitly
	//Whichever method you Use, among the above two, the Tomcat internally will call the service method and which will 
	//then check the method type and call the specific method
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//the name mentioned in your index.html page for your variables
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
		PrintWriter out = res.getWriter();
		out.print("Result is "+ k);
		//calling another servlet from this servlet using ReqDispatcher , Make sure to also mention it in 
		//the web.xml file , 
		
	    //now how to pass data to the other servlet?
		//There is a concept of session management to share or pass data among servlets
		//but we can also do it by attaching it to the request object since anyway we'll have to pass it
		req.setAttribute("k", k);
		
		
		//since Request Dispatcher is an interface we are creating the object of it using req object
		//This below line along with Web.xml can be used to call the SqServlet
		RequestDispatcher rd=req.getRequestDispatcher("sq");
		rd.forward(req, res);
		
		//this is Session Management's URL Rewriting this is done using response object
//		res.sendRedirect("sq?k="+k);
		
		
		
		
	}

}
