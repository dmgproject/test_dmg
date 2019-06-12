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
		
		String userId = ((Member)session.getAttribute("member")).getUserId();

		MemberService ms = new MemberService();
		
		try {
			ms.deleteMember(userId);
			
			session.invalidate();
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" +"회원 탈퇴가 완료되었습니다." + "');");
			out.println("location.href='index.jsp'");
			out.println("</script>");
			//response.sendRedirect("index.jsp");
			
			
		} catch(MemberException e){
			
			request.setAttribute("msg", "회원 탈퇴 중 에러 발생!!");
			
			request.setAttribute("exception", e);
			
			// 수정 요망
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
			
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
