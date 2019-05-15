package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kwd = request.getParameter("kwd");
		if(kwd == null) kwd = "";
		String kwd_decode = URLDecoder.decode(kwd, "utf-8");
		String kwd_encode = URLEncoder.encode(kwd_decode, "utf-8");
		request.setAttribute("kwd_decode", kwd_decode);
		request.setAttribute("kwd_encode", kwd_encode);
		
		
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
		
		WebUtil.forword(request, response, "/WEB-INF/views/board/write.jsp");
	}

}
