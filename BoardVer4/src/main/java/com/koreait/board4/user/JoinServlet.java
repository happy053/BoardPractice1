package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("/user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid"); 
		String upw = request.getParameter("upw"); 
		String unm = request.getParameter("unm"); 
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		vo.setUnm(unm);
		vo.setGender(MyUtils.Inte("gender", request));
		
		UserDAO.inUser(vo);
		
		response.sendRedirect("login");
	}

}
