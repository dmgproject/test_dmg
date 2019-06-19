package com.dmg.jsp.notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dmg.jsp.notice.model.exception.NoticeException;
import com.dmg.jsp.notice.model.service.NoticeService;
import com.dmg.jsp.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/*
 * DMG.COM 
 * 2019.06.01
 */
@WebServlet("/nInsert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("insert 실행");
		int maxSize = 1024 * 1024 * 10;
		System.out.println("2");
		String root = request.getServletContext().getRealPath("/");
		String savePath = root + "resources/noticeUploadFiles";
		Notice n = new Notice();
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
			// 에러 페이지로 즉시 이동 시킨다.
			System.out.println("xx");		
			String ntitle = request.getParameter("title");
			String writer = request.getParameter("userId"); // admin
			String content = request.getParameter("content").replace("\r\n","<br>");
			//request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			//request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			n.setNtitle(ntitle);
			n.setNcontent(content);
			//n.setNdate(writeDate);
			n.setNwriter(writer);
				
		} else {
			System.out.println("oo");
			MultipartRequest mrequest = new MultipartRequest(
					request, // 변경하기 위한 원본 객체
					savePath, // 파일 저장 경로
					maxSize, // 저장할 파일의 최대 크기
					"UTF-8", // 저장할 문자셋 설정
					new DefaultFileRenamePolicy() 
					// 만약에 동일한 이름의 파일을 저장했을 경우 기존의 파일과 구분하기 위해 새로운 파일명 뒤에 숫자를 붙이는 규칙
					// OOO.txt ---> OOO1.txt
					);
			String fileName = mrequest.getFilesystemName("file");
			String ntitle = mrequest.getParameter("title");
			String writer = mrequest.getParameter("userId"); // admin
			String content = mrequest.getParameter("content").replace("\r\n","<br>");
			n.setNtitle(ntitle);
			n.setNcontent(content);
			//n.setNdate(writeDate);
			n.setNwriter(writer);
			n.setNboardfile(fileName);
			System.out.println(fileName);
		}
		
		
		// 공지사항 제목, 작성자, 내용
//		String ntitle = request.getParameter("title");
//		String writer = request.getParameter("userId"); // admin
//		String content = request.getParameter("content").replace("\r\n","<br>");
		System.out.println("3");
		

		//String date = request.getParameter("date");
		//Date writeDate = null;
		System.out.println("4");
//		if(date != "" && date != null) {
//			String[] dateArr = date.split("-");
//			int[] intArr = new int[dateArr.length];
//
//			for(int i = 0 ; i < dateArr.length ; i++ ) {
//				intArr[i] = Integer.parseInt(dateArr[i]);
//			}
//			writeDate = new Date(
//					new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
//		
//		} else {
//			writeDate = new Date(new GregorianCalendar().getTimeInMillis());
//		}
//		System.out.println("5");
		
		
//		n.setNtitle(ntitle);
//		n.setNcontent(content);
//		//n.setNdate(writeDate);
//		n.setNwriter(writer);
		
		NoticeService ns = new NoticeService();
		System.out.println("6");
		try {
			
			ns.insertNotice(n);
			System.out.println("공지사항 추가 완료!");
			
			response.sendRedirect("selectList.no");
			
		}catch(NoticeException e) {
			
			request.setAttribute("msg", "공지사항 등록 실패!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
