package com.dmg.jsp.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.notice.model.exception.NoticeException;
import com.dmg.jsp.notice.model.service.NoticeService;
import com.dmg.jsp.notice.model.vo.Notice;

/*
 * DMG.COM 
 * 2019.06.01
 */
@WebServlet("/searchNotice.no")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색 카테고리
		String category = request.getParameter("con");
		
		// 검색 키워드
		String keyword = request.getParameter("keyword");
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		NoticeService ns = new NoticeService();
		
		String page = "";
		
		try {
			
			list = ns.searchNotice(category, keyword);
			System.out.println("공지사항 검색 완료!");
			
			page = "views/notice/noticeList.jsp";
			request.setAttribute("list", list);
			
			request.getRequestDispatcher(page).forward(request, response);
			
		}catch(NoticeException e) {
			
			request.setAttribute("msg", "공지사항 검색 실패!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
