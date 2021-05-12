package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/up")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		int ib = MyUtils.Inte("ib", request);
		
		BoardVO vo = BoardDAO.selD(ib);
		
		request.setAttribute("data", vo);
		
		
		MyUtils.openJSP("/board/up", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int ib = MyUtils.Inte("ib", request);
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(ib);
		vo.setIuser(iuser);
		
		BoardDAO.Update(vo);
		
		response.sendRedirect("/board/detail?ib=" + ib);
	}

}
