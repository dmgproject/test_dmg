package com.dmg.jsp.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dmg.jsp.common.MyRenamePolicy;
import com.dmg.jsp.product.model.service.ProductService;
import com.dmg.jsp.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet("/pInsert.do")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("서블릿 실행중");
		// 접속 가능

		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("error 입니다");
			request.setAttribute("msg", "multi part 폼으로 보내야 합니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		int maxSize = 1024 * 1024 * 10;
		String root = request.getServletContext().getRealPath("/resources");
		String savePath = root + "/productUpload/";

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
		
		
		String changeFile = null;
		String originFile = null;
		Enumeration<String> files = mrequest.getFileNames();

		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			changeFile = mrequest.getFilesystemName(fileName);
			originFile = mrequest.getOriginalFileName(fileName);
		}
/*		PrintWriter out = response.getWriter();
		out.print("http://localhost:8088/DMG/resources/productUpload/" + fileName);
		out.flush();
		out.close();
		ArrayList<String> changeFiles = new ArrayList<String>();
		ArrayList<String> originFiles = new ArrayList<String>();

		Enumeration<String> files = mrequest.getFileNames();
		while (files.hasMoreElements()) {
			String name = files.nextElement();
			System.out.println("name : " + name);
			changeFiles.add(mrequest.getFilesystemName(name));
			originFiles.add(mrequest.getOriginalFileName(name));
		}

		ArrayList<ProductAttachment> list = new ArrayList<>();

		for (int i = originFiles.size() - 1; i >= 0; i--) {
			ProductAttachment pa = new ProductAttachment();

			pa.setFilePath(savePath);
			pa.setOriginFileName(originFiles.get(i));
			pa.setChangeFileName(changeFiles.get(i));
			list.add(pa);
		}
*/
		String categoryL = mrequest.getParameter("categoryL");
		String categoryM = mrequest.getParameter("categoryM");
		String categoryS = mrequest.getParameter("categoryS");
		String pname = mrequest.getParameter("pname");
		System.out.println(pname);
		int pprice = Integer.parseInt(mrequest.getParameter("pprice"));
		int pweight = Integer.parseInt(mrequest.getParameter("pweight"));
		String punit = mrequest.getParameter("punit");
		String pcontent = mrequest.getParameter("summernote");
		System.out.println("pcontent " +pcontent);
//		String pt = mrequest.getParameter("mfile"); // 썸네일
//		String[] ps = mrequest.getParameterValues("sfile"); // 서브 사진
//		String[] pp = mrequest.getParameterValues("pfile"); // 상품 사진

//		Product product = new Product(	cate1,pcate2,pcate3,pname,pprice,pweight,punit,pcontent);
		Product product = new Product();
		product.setCategoryL(categoryL);
		product.setCategoryM(categoryM);
		product.setCategoryS(categoryS);
		product.setPcontent(pcontent);
		product.setPname(pname);
		product.setPprice(pprice);
		product.setPunit(punit);
		product.setPweight(pweight);
		product.setPcontent(pcontent);
		product.setPfile(changeFile);
		int result = new ProductService().insertProduct(product);

		if (result > 0)
		{
			System.out.println("성공");
			response.sendRedirect("/DMG/pList.do");
		}else
			System.out.println("실패");

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
