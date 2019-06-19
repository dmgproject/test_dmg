package com.dmg.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.member.model.service.MemberService;


@WebServlet("/nickDup.me")
public class MemberNickDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberNickDuplicateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print((new MemberService()
				.nickDupCheck(request.getParameter("userNickName"))> 0) ? "no" : "ok");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
