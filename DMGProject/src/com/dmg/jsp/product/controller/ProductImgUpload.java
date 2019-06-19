package com.dmg.jsp.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dmg.jsp.common.MyRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProductImgUpload
 */
@WebServlet("/pImgUpload.do")
public class ProductImgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductImgUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 업로드할 파일의 용량 제한 : 10Mbyte로 제한한다면
	      int maxSize = 1024 * 1024 * 10;
	      System.out.println("pImg 서블릿 실행중");
	      RequestDispatcher view = null;
	      // enctype="multipart/form-data" 로 전송되었는지 확인
	      if (!ServletFileUpload.isMultipartContent(request)) {
	         view = request.getRequestDispatcher("404-page.jsp");
	         request.setAttribute("message", "form enctype 속성 사용 안 됨!");
	         view.forward(request, response);
	      }

	      // 해당 컨테이너의 구동중인 웹 애플리케이션의 루트 경로 알아냄
	      String root = request.getSession().getServletContext().getRealPath("/resources");
	      // 업로드되는 파일이 저장될 폴더명과 경로 연결 처리
	      String savePath = root + "/productUpload/";
	      // web/nuploadFiles 로 지정함
	      // request 를 MultipartRequest 객체로 변환함
	      MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());

	      String fileName = mrequest.getFilesystemName("file");
	      PrintWriter out = response.getWriter();
	      out.print("http://localhost:8088/DMG/resources/productUpload/" + fileName);
	      out.flush();
	      out.close();


	      System.out.println("pImg 서블릿 실행끝");
	      //
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
