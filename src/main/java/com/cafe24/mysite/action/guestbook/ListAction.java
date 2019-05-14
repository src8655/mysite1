package com.cafe24.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		
		for(GuestbookVo vo : list) {
			vo.setContents(vo.getContents().replaceAll("\\n", "<br />"));
		}

		request.setAttribute("list", list);
		request.setAttribute("cnt", list.size());
		
		WebUtil.forword(request, response, "/WEB-INF/views/guestbook/list.jsp");
	}

}
