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

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null) {
			WebUtil.redirect(request, response, "./");
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			WebUtil.redirect(request, response, "./");
			return;
		}
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserDao dao = new UserDao();
		UserVo userVo = dao.get(authUser.getNo());
		
		userVo.setName(name);
		userVo.setPassword(password);
		userVo.setGender(gender);
		
		dao.update(userVo);
		
		session.setAttribute("authUser", userVo);
		
		WebUtil.redirect(request, response, "./");
	}

}
