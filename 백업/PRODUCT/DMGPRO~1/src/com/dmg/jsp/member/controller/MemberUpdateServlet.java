package com.dmg.jsp.member.controller;

import java.io.IOException;
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
 *  DMG.COM 회원정보 수정 서블렛.
 * 	2019.06.03
 */
@WebServlet("/mUpdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("userPwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String nickName = request.getParameter("userNickName");
		String email = request.getParameter("email");
		String phone = request.getParameter("tel1")+"-"
				+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String address = request.getParameter("zipCode")+"/ "
				+request.getParameter("address1")+"/ "
					+request.getParameter("address2");
		
		// 해당 회원을 구분짓는 ID 받아오기
		HttpSession session = request.getSession(false);
		
		Member m = (Member)session.getAttribute("member");
		
		m.setUserPwd(pwd);
		m.setAge(age);
		m.setEmail(email);
		m.setUserNickName(nickName);
		m.setPhone(phone);
		m.setAddress(address);

		MemberService ms = new MemberService();
		try {
			ms.updateMember(m);
			System.out.println("회원 정보 수정 완료!!");
			// 수정 요망
			response.sendRedirect("index.jsp");
		}catch(MemberException e) {
			request.setAttribute("msg", "회원 정보 수정 중 에러 발생!!");
			request.setAttribute("expception", e);
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
