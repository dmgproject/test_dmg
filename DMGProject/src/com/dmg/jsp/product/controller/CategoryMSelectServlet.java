package com.dmg.jsp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.product.model.service.ProductService;
import com.dmg.jsp.product.model.vo.ProCategory;
import com.google.gson.Gson;

/**
 * Servlet implementation class CategoryMSelectServlet
 */
@WebServlet("/cMselect.do")
public class CategoryMSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryMSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8"); 
		String selectedL = request.getParameter("selectedL");		
		ArrayList<ProCategory> mlist = new ProductService().selectMcategory(selectedL);
//		request.setAttribute("mlist", mlist);
//		response.getWriter().print(mlist);
		new Gson().toJson(mlist, response.getWriter());
//		request.getRequestDispatcher("views/product/productInsert.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
