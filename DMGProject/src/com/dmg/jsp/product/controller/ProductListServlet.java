package com.dmg.jsp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.common.PageInfo;
import com.dmg.jsp.product.model.service.ProductService;
import com.dmg.jsp.product.model.vo.Product;

/**
 * Servlet implementation class productListServlet
 */
@WebServlet("/pList.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
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
		String keyword =request.getParameter("keyword");
		String query ;
		String value;
		String category = "A";
		currentPage =1;
		limit = 8;
		if(request.getParameter("currentPage")!=null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int listCount;

		if(keyword == null) {
			query = "lid";
			value = category;
			System.out.println(value+"value");
			listCount = ps.getListCount(query,category);
		}else{
			query = "pname";
			value=keyword;
			listCount = ps.getListCount(query,keyword);
		}
		System.out.println("listcount " + listCount);
		maxPage = (int)((double)listCount/limit+0.9);
		startPage = ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		endPage = startPage + limit-1;
		if(endPage>maxPage)
			endPage = maxPage;
		
	
		products = ps.selectProductList(query,value,currentPage , limit);
		String page="";
		
		if(products != null) {
			page = "views/product/productList.jsp";
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);	
			request.setAttribute("products",products);
			request.setAttribute("category", category);}
		else {
			
			page ="views/common/errorPage.jsp";
			request.setAttribute("msg", "productListServlet 에러");
		}
		request.getRequestDispatcher(page).forward(request,response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
