package com.dmg.jsp.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dmg.jsp.common.MyRenamePolicy;
import com.dmg.jsp.recipe.model.exception.RecipeException;
import com.dmg.jsp.recipe.model.service.RecipeService;
import com.dmg.jsp.recipe.model.vo.Attachment;
import com.dmg.jsp.recipe.model.vo.Recipe;
import com.dmg.jsp.recipe.model.vo.RecipeSub;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class RecipeUpdateServlet
 */
@WebServlet("/rUpdate.re")
public class RecipeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeUpdateServlet() {
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
		
		int renum = Integer.parseInt(mrequest.getParameter("renum"));
		
		System.out.println(renum);
		
		
		// 원본 파일 경로 확인하기
		HashMap<String, Object> hmap = rs.selectThumbnailMap(renum);
		
		//ArrayList<RecipeSub> list = rs.selectRecipSub(renum);
		
		
		
		String saveFile = mrequest.getFilesystemName("file");
		String originFile = mrequest.getOriginalFileName("file");
		
		Recipe r = (Recipe)hmap.get("recipe");
		
		RecipeSub rcs = new RecipeSub();
		
		r.setRename(mrequest.getParameter("rename"));
		r.setRemain(mrequest.getParameter("remain"));
		r.setRecipe(mrequest.getParameter("recipe"));
		r.setResub(mrequest.getParameter("resub"));
		
		
		rcs.setResub(mrequest.getParameter("resub"));
		rcs.setRecount(mrequest.getParameter("resubcount"));
		
		
		// 기존 파일 삭제
		
		
		Attachment am = (Attachment)hmap.get("attachment");
		
		System.out.println("att :  " + am.getRenum());
		
		if(originFile != null) {
			
		new File(savePath + am.getChangename()).delete();
		
		am.setFilepath(savePath);
		am.setChangename(saveFile);
		am.setOriginname(originFile);
		
		}
		
		int result = 0;
		
		try {
			
			result = rs.updateRecipe(r, am, rcs);
			
			System.out.println("try  " + am.getRenum());
			
			response.sendRedirect("rList.re");
			
		} catch (RecipeException e) {
			
			//request.setAttribute("msg", "파일 전송 실패!!");
			e.printStackTrace();
			//request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
//		if(result > 0) {
//			
//			response.sendRedirect("rList.re");
//			
//		}else {
//			
//			request.setAttribute("msg", "파일 전송 실패!!");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//			
//		}
		
		

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
