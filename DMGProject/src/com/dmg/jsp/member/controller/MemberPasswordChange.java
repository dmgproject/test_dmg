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

@WebServlet("/passchange.me")
public class MemberPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberPasswordChange() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
        String AuthenticationUser = request.getParameter("AuthenticationUser");
        PrintWriter out = response.getWriter();
        if(!AuthenticationKey.equals(AuthenticationUser))
        {
            System.out.println("인증번호 일치하지 않음");
            request.setAttribute("msg", "인증번호가 일치하지 않습니다");
            request.setAttribute("loc", "/member/searchPw");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
        } else {
        	System.out.println("비밀번호 변경 시작");
        	
        	String pwd = request.getParameter("password");
        	String id = (String) request.getAttribute("id");
            Member m = new Member(id,pwd);
            MemberService ms = new MemberService();

			ms.passwordupdate(m);
//			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + "비밀 번호 변경이 완료 되었습니다." + "');");
			out.println("location.href='index.jsp'");
			out.println("</script>");

        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
