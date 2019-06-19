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

@WebServlet("/mDelete.me")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = request.getParameter("userId");
		String userId2 = ((Member)session.getAttribute("member")).getUserId();
		String userPwd = request.getParameter("userPwd");
		System.out.println(userId);
		System.out.println(userId2);
		System.out.println(userPwd);
		
		if (userId.equals(userId2)) {
			MemberService ms = new MemberService();
			PrintWriter out = response.getWriter();
			try {
				ms.deleteMember(userId, userPwd);

				session.invalidate();


				out.println("<script>");
				out.println("alert('" + "회원 탈퇴가 완료되었습니다." + "');");
				out.println("location.href='index.jsp'");
				out.println("</script>");
				// response.sendRedirect("index.jsp");

			} catch (MemberException e) {

				out.println("<script>");
				out.println("alert('" + "비밀번호를 확인해 주세요." + "');");
				out.println("location.href='index.jsp'");
				out.println("</script>");

			}

		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + "아이디를 확인해 주세요." + "');");
			out.println("location.href='/DMG/views/member/update.jsp'");
			out.println("</script>");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
