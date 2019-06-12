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
import com.dmg.jsp.notice.model.vo.PageInfo;
/*
 * DMG.COM 
 * 2019.06.01
 */
@WebServlet("/selectList.no")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Notice> list = new ArrayList<>();
		
		NoticeService ns = new NoticeService();

		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 10;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = ns.getListCount();
		System.out.println("1");
		maxPage = (int)((double)listCount / limit + 0.9);
		

		startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		

		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
	
		
		
		String page = "";

		try {
			list = ns.selectList(currentPage, limit);

			
			page = "views/notice/noticeList.jsp";
			request.setAttribute("list", list);

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			request.setAttribute("pi", pi);

			
			request.getRequestDispatcher(page).forward(request, response);
			
		}catch(NoticeException e) {
			
			request.setAttribute("msg", "공지사항 목록 보기 실패!!");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
