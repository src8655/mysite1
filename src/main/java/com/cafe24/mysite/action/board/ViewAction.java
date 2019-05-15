package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = boardDao.selectOne(no);
		boardVo.setContents(boardVo.getContents().replaceAll("\\n", "<br />"));
		request.setAttribute("boardVo", boardVo);
		
		WebUtil.forword(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
