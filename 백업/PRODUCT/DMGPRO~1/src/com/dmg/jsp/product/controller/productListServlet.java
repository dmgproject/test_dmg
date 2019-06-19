package com.dmg.jsp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.notice.model.vo.PageInfo;
import com.dmg.jsp.product.model.service.ProductService;
import com.dmg.jsp.product.model.vo.Product;

/**
 * Servlet implementation class productListServlet
 */
@WebServlet("/pList.do")
public class productListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productListServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Product> products = new ArrayList<>();
		
		ProductService ps = new ProductService();
		int startPage ;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage =1;
		limit = 10;
		if(request.getParameter("currentPage")!=null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int listCount = ps.getListCount();
		
		maxPage = (int)((double)listCount/limit+0.9);
		startPage = ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		endPage = startPage + limit-1;
		if(endPage>maxPage)
			endPage = maxPage;
		
		String category = "A";
		products = ps.selectProductList(category,currentPage , limit);
		String page="";
		
		if(products != null) {
			page = "views/product/productList.jsp";
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
		}
		request.setAttribute("products",products);
		request.setAttribute("category", category);
		request.getRequestDispatcher("views/product/productList.jsp").forward(request,response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
