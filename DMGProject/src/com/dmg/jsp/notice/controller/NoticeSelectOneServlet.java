package com.dmg.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.notice.model.exception.NoticeException;
import com.dmg.jsp.notice.model.service.NoticeService;
import com.dmg.jsp.notice.model.vo.Notice;

@WebServlet("/selectOne.no")
public class NoticeSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeService ns = new NoticeService();
		
		String page = "";

		try {
			
			Notice n = ns.selectOne(nno);
			System.out.println("공지사항 상세보기 성공!!");
			page = "views/notice/noticeDetail.jsp";
			request.setAttribute("notice", n);
			
			request.getRequestDispatcher(page).forward(request, response);
			
		} catch (NoticeException e) {
			
			request.setAttribute("msg", "공지사항 상세 보기 실패!!");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
