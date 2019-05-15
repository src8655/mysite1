package com.cafe24.mysite.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.main.MainActionFactory;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

/**
 * Servlet implementation class MainServlet
 */

//@WebServlet("/index")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init() throws ServletException {
		String configPath = getServletConfig().getInitParameter("config");
		System.out.println("init() called : " + configPath);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionFactory actionFactory = new MainActionFactory();
		Action action = actionFactory.getAction("");
		action.execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
