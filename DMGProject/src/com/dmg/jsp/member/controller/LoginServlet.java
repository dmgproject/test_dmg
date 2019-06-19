package com.dmg.jsp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmg.jsp.member.model.exception.MemberException;
import com.dmg.jsp.member.model.service.MemberService;
import com.dmg.jsp.member.model.vo.Member;

@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userId + " " + userPwd);
		Member m = new Member(userId, userPwd);
		
		MemberService ms = new MemberService();
		PrintWriter out = response.getWriter();
		try {
			m = ms.selectMember(m);

			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			//PrintWriter out = response.getWriter();
			if (m.getStatus().equals("N")) {
				out.println("<script>");
				out.println("alert('" + m.getUserId() 
					+ " 님은 탈퇴 대기중인 회원님입니다" + "');");
				out.println("location.href='index.jsp'");
				//out.println("opener.location.reload();");
				out.println("window.close();");
				out.println("</script>");

				if(session != null) {
					session.invalidate();
				}
				out.close();

			} else {
				out.println("<script>");
				out.println("alert('" + m.getUserId() + " 님 환영합니다!" + "');");
				out.println("location.href='index.jsp'");
				//out.println("opener.location.reload();");
				out.println("window.close();");
				out.println("</script>");
				out.close();

			}
		}catch(MemberException e) {

			out.println("<script>");
			out.println("alert('아이디 혹은 비밀번호를 확인해 주세요.');");
			//out.println("location.href='index.jsp'");
			//out.println("opener.location.reload();");
			out.println("location.href='index.jsp'");
			out.println("window.close();");
			out.println("</script>");
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
