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

@WebServlet("/cLselect.do")
public class CategoryLSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryLSelectServlet() {
        super();

       
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ProCategory> llist = new ProductService().selectLcategory();
		request.setAttribute("llist", llist);
		request.getRequestDispatcher("views/product/productInsert.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
