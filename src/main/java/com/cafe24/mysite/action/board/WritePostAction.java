
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

public class WritePostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		
		BoardVo vo = new BoardVo();
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setHit(0L);
		vo.setUserNo(authUser.getNo());
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
		
		WebUtil.redirect(request, response, "./board?a=list");
	}

}
