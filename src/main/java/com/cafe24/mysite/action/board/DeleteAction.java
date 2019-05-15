package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		
		HttpSession session = request.getSession();
		if(session == null) {
			WebUtil.redirect(request, response, "./board?a=list");
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			WebUtil.redirect(request, response, "./board?a=list");
			return;
		}
		
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = boardDao.selectOne(no);
		
		//내 글만 수정
		if(authUser.getNo() != boardVo.getUserNo()) {
			WebUtil.redirect(request, response, "./board?a=list");
			return;
		}
		
		WebUtil.redirect(request, response, "./board?a=list");
	}

}