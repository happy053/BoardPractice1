package com.koreait.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String a, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String jsp = "/WEB-INF/view" + a + ".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
	
	public static int Inte(String num, HttpServletRequest req) {
		return parseSTI(req.getParameter(num));
	}
	
	public static int parseSTI(String val) {
		try {
			return Integer.parseInt(val);
		} catch(Exception e) {
			int a = 1;
			System.out.println(a);
			return a;
		}
	}
}
