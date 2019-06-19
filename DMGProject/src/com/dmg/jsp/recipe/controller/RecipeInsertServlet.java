package com.dmg.jsp.recipe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dmg.jsp.common.MyRenamePolicy;
import com.dmg.jsp.recipe.model.service.RecipeService;
import com.dmg.jsp.recipe.model.vo.Attachment;
import com.dmg.jsp.recipe.model.vo.Recipe;
import com.dmg.jsp.recipe.model.vo.RecipeSub;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class RecipeInsertServlet
 */
@WebServlet("/rInsert.re")
public class RecipeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RecipeService rs = new RecipeService();

		if (!ServletFileUpload.isMultipartContent(request)) {

			request.setAttribute("msg", "멀티파트 폼으로 전송해야 합니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);

		}

		// 1. 전송할 파일의 크기 설정하기
		int maxSize = 1024 * 1024 * 10; // 10MB

		// 2. 저장할 경로 설정하기
		String root = request.getServletContext().getRealPath("/resources");

		String savePath = root + "/recipeUpload/";

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());

		// 변경된 파일 명
		String saveFile = null;

		// 원본 파일 명
		String originFile = null;

		// 폼으로 전송된 파일 이름들 가져오기
		saveFile = mrequest.getFilesystemName("file");
		originFile = mrequest.getOriginalFileName("file");

		// Thumbnail VO 객체 생성하여 DB에 전달할 내용 채우기
		Recipe r = new Recipe();

		r.setRename(mrequest.getParameter("rename"));
		r.setRecipe(mrequest.getParameter("recipe"));
		r.setRemain(mrequest.getParameter("remain"));
		r.setResub(mrequest.getParameter("resub"));
		
		RecipeSub rcs = new RecipeSub();
		rcs.setResub(mrequest.getParameter("resub"));
		
		System.out.println("resub (ser): " + rcs.getResub());
		rcs.setRecount(mrequest.getParameter("recount"));

		System.out.println("servlet : " + r.getRename());
		
		
		Attachment at = new Attachment();
		at.setFilepath(savePath);
		at.setOriginname(originFile);
		at.setChangename(saveFile);

		// 리스트에 파일 목록 하나씩 저장하기

		int result = rs.insertThumbnail(r, at, rcs);

		System.out.println(result);
		
		if (result > 0) {
			response.sendRedirect("rList.re");
		} else {
			request.setAttribute("msg", "파일 전송 실패!");

			// 이전 파일 정보 삭제하기
				File file = new File(savePath + saveFile);

				System.out.println("파일 삭제 확인 : " + file.delete());


		}
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
