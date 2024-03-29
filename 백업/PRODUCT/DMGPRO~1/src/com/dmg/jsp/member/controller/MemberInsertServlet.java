package com.dmg.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.member.model.exception.MemberException;
import com.dmg.jsp.member.model.service.MemberService;
import com.dmg.jsp.member.model.vo.Member;

/*
 *  DMG.COM 회원정보 추가 서블렛.
 * 	2019.06.02
 */
@WebServlet("/mInsert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInsertServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");				// ID
		String userPwd = request.getParameter("userPwd");			// 비밀번호
		String userName = request.getParameter("userName");			// 이름
		String userNickName = request.getParameter("userNickName"); // 닉네임
		String gender = request.getParameter("gender");				// 성별
		int age = Integer.parseInt(request.getParameter("age"));	// 나이
		String email = request.getParameter("email");				// 이메일 주소
		String phone = request.getParameter("tel1")+"-"+			// 연락처
				request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String address = request.getParameter("zipCode")+"/ "+		// 주소
				request.getParameter("address1")+"/ "+request.getParameter("address2");
				
		// 회원 가입시 전달을 위한 vo 생성
		Member m = new Member(userId,userPwd,userName,userNickName,
				gender,age,email,phone,address);
		
		System.out.println("회원 가입 toString : " + m);
		
		// 회원 가입 서비스 실행
		MemberService ms = new MemberService();
		
		try {
			
			ms.insertMember(m);
			System.out.println("회원 가입 완료!");
		
			response.sendRedirect("index.jsp");
		
		} catch(MemberException e) {
			request.setAttribute("msg", "회원 가입 중 에러 발생!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
		}
	}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
