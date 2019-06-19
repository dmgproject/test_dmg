package com.dmg.jsp.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.recipe.model.service.RecipeService;
import com.dmg.jsp.recipe.model.vo.RecipeSub;

/**
 * Servlet implementation class RecipeSelectOneServlet
 */
@WebServlet("/rSelectOne.re")
public class RecipeSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeSelectOneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int renum = Integer.parseInt(request.getParameter("renum"));
		HashMap<String, Object> rcp = new RecipeService().selectThumbnailMap(renum);
		ArrayList<RecipeSub> list = new RecipeService().selectRecipSub(renum);
		
		System.out.println("list.isEmpty() : " + list.isEmpty());

		// System.out.println(thumb);

//		ArrayList<BoardComment> clist = new BoardCommentService().selectList(bno);

		String page = "";

		if (rcp != null && rcp.get("attachment") != null) {

			page = "views/thumbnail/reDetail.jsp";
			request.setAttribute("recipe", rcp.get("recipe"));
			request.setAttribute("file", rcp.get("attachment"));
			request.setAttribute("list", list);
//			request.setAttribute("clist", clist);

		} else {

			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패!");

		}

		request.getRequestDispatcher(page).forward(request, response);
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
