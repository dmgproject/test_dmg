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
@WebServlet("/nUpdate.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content").replace("\r\n","<br>");
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		Notice n = new Notice();
		
		n.setNno(nno);
		n.setNcontent(content);
		n.setNtitle(title);
		
		NoticeService ns = new NoticeService(); 
		
		try {
			
			ns.updateNotice(n);
			System.out.println("공지사항 수정 성공!");
			
			response.sendRedirect("selectOne.no?nno="+nno);
			
			
		}catch(NoticeException e) {
			
			request.setAttribute("msg", "공지사항 수정 실패!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
