package com.dmg.jsp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmg.jsp.member.model.exception.MemberException;
import com.dmg.jsp.member.model.service.MemberService;
import com.dmg.jsp.member.model.vo.Member;

@WebServlet("/findid.me")
public class MemberIdFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberIdFind() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName"); // 이름
		String email = request.getParameter("email"); // 이메일 주소
		MemberService ms = new MemberService();
		PrintWriter out = response.getWriter();

		String findId;
		try {
			findId = ms.findid(userName, email);
			if (findId == null) {
				out.println("<script>");
				out.println("alert('일치하는 회원이 없습니다.');");
				out.println("location.href='index.jsp'");
				out.println("window.close();");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('" + "회원님의 ID 는 " + findId + " 입니다!" + "');");
				out.println("location.href='index.jsp'");
				out.println("window.close();");
				out.println("</script>");
				out.close();
			}
		} catch (MemberException e) {
			out.println("<script>");
			out.println("alert('일치하는 회원이 없습니다.');");
			out.println("location.href='index.jsp'");
			out.println("window.close();");
			out.println("</script>");
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
