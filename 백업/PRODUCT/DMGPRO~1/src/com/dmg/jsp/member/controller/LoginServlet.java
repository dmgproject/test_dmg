package com.dmg.jsp.member.controller;

import java.io.IOException;

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

/*
 *  DMG.COM 로그인 서블렛.
 * 	2019.06.03
 */


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
		
		Member m = new Member(userId, userPwd);
		
		MemberService ms = new MemberService();
		
		try {
			
			/*
			 * 	if 문을 통하여 status를 받아와서 만약 'N' 이라면
			 * 	탈퇴 대기중인 회원 입니다 ALERT을 띄운 후 , 
			 * 	MEMBER를 NULL로 최기화 시킨다.
			 * 
			 */
			m = ms.selectMember(m);

			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			
			// ALERT이후 이동하도록 /* ~ 님 환영합니다 */수정 요망
			response.sendRedirect("index.jsp");
			
		}catch(MemberException e) {
			
			request.setAttribute("msg", "회원 로그인 실패!");
			request.setAttribute("exception", e);
			
			// 수정 요망
			request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
			
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
