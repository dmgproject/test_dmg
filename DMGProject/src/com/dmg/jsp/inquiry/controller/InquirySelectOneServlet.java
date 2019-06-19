package com.dmg.jsp.inquiry.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.inquiry.Comment.model.vo.InquiryComment;
import com.dmg.jsp.inquiry.Comment.service.InquiryCommentService;
import com.dmg.jsp.inquiry.model.service.InquiryService;
import com.dmg.jsp.inquiry.model.vo.Inquiry;

/**
 * Servlet implementation class BoardSelectOneServlet
 */
@WebServlet("/selectOne.iq")
public class InquirySelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquirySelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ino = Integer.parseInt(request.getParameter("ino"));
		
		Inquiry i = new InquiryService().selectOne(ino);
		ArrayList<InquiryComment> clist
			= new InquiryCommentService().selectList(ino);
		
		String page = "";
		if(i != null) {
			page = "views/inquiry/inquiryDetail.jsp";
			request.setAttribute("inquiry", i);
			request.setAttribute("clist", clist);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패 +_+");
			
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
