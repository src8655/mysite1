package com.cafe24.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.user.UserActionFactory;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("a");
		
		ActionFactory actionFactory = new UserActionFactory();
		Action action = actionFactory.getAction(actionName);
		
		action.execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
