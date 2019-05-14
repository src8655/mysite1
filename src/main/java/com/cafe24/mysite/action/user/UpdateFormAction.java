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

public class UpdateFormAction implements Action {

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
		
		UserDao dao = new UserDao();
		
		UserVo userVo = dao.get(authUser.getNo());
		
		request.setAttribute("userVo", userVo);
		
		WebUtil.forword(request, response, "/WEB-INF/views/user/updateform.jsp");
	}

}
