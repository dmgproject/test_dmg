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
/*
 * DMG.COM 
 * 2019.06.01
 */
@WebServlet("/nDelete.no")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeService ns = new NoticeService();
		
		
		try {
			
			ns.deleteNotice(nno);
			System.out.println("공지 사항 삭제 성공!");
			
			response.sendRedirect("selectList.no");
			
		}catch(NoticeException e) {
			
			request.setAttribute("msg", "공지사항 삭제 실패");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}
}
