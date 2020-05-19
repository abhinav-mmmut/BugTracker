package com.Abhinav.AddBugDetails;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Abhinav.Doa.BugDoa;


public class AddBugDetailsServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(request.getSession().getAttribute("username")==null){
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		String bugname=request.getParameter("bugname");
		String bugdetails=request.getParameter("bugdetails");
		String employee=request.getParameter("employee");
		if(bugname.equals("") || bugdetails.equals("") || employee.equals(""))
			{request.getRequestDispatcher("Addbugdetails.jsp").forward(request, response);return;}
		BugDoa bugdoa= new BugDoa();
		bugdoa.addbug(bugname,bugdetails,employee);
		ArrayList<Bug> al=bugdoa.show();
		//request.setAttribute("name","Abhinav");
		request.setAttribute("list",al);
		request.getRequestDispatcher("Bugs.jsp").forward(request, response);
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		if(request.getSession().getAttribute("username")==null){
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		BugDoa bugdoa= new BugDoa();
		ArrayList<Bug> al=bugdoa.show();
		//request.setAttribute("name","Abhinav");
		request.setAttribute("list",al);
		request.getRequestDispatcher("Bugs.jsp").forward(request, response);
		}

}
