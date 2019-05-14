package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		UserVo authUser = dao.get(email, password);
		
		if(authUser == null) {
			request.setAttribute("result", "fail");
			WebUtil.forword(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);
		
		
		WebUtil.redirect(request, response, "./");
	}

}
