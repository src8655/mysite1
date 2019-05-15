package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kwd = request.getParameter("kwd");
		if(kwd == null) kwd = "";
		String kwd_decode = URLDecoder.decode(kwd, "utf-8");
		String kwd_encode = URLEncoder.encode(kwd_decode, "utf-8");
		request.setAttribute("kwd_decode", kwd_decode);
		request.setAttribute("kwd_encode", kwd_encode);
		
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList(kwd_decode);
		
		request.setAttribute("list", list);
		request.setAttribute("cnt", list.size());
		
		WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
