package com.cafe24.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.guestbook.GuestbookActionFactory;
import com.cafe24.mysite.dao.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

/**
 * Servlet implementation class GuestbookServlet
 */
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("a");
		
		ActionFactory actionFactory = new GuestbookActionFactory();
		Action action = actionFactory.getAction(actionName);
		
		action.execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
