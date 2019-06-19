package com.dmg.jsp.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmg.jsp.common.PageInfo;
import com.dmg.jsp.product.model.service.ProductService;
import com.dmg.jsp.product.model.vo.Product;

/**
 * Servlet implementation class ProductSelectOne
 */
@WebServlet("/pSelectOne.do")
public class ProductSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));

		Product product = new ProductService().selectOne(pid);
		String page;
		if(product != null) {
			page = "views/product/productDetailForm.jsp";
			request.setAttribute("product", product);}
		else {
			page ="views/common/errorPage.jsp";
			request.setAttribute("msg", "productSelectOne 에러");
		}
		request.getRequestDispatcher(page).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
