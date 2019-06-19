package com.dmg.jsp.product.model.service;

import static com.dmg.jsp.common.JDBCTemplate.close;
import static com.dmg.jsp.common.JDBCTemplate.commit;
import static com.dmg.jsp.common.JDBCTemplate.getConnection;
import static com.dmg.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.dmg.jsp.product.model.dao.ProductDao;
import com.dmg.jsp.product.model.vo.ProCategory;
import com.dmg.jsp.product.model.vo.Product;
import com.dmg.jsp.product.model.vo.ProductAttachment;

public class ProductService {

	private ProductDao pDao = new ProductDao();

	public int insertProduct(Product product) {

		Connection con = getConnection();
		int result = pDao.insertProduct(con , product);
		if(result > 0)
			commit(con);
		else rollback(con);
		return result;
	
	}

	public ArrayList<ProCategory> selectLcategory() {
		Connection con = getConnection();
		ArrayList<ProCategory> llist = pDao.selectLcategory(con);
		System.out.println(llist.get(0));
		if(llist == null || llist.isEmpty()) {
			rollback(con);
			System.out.println("L실패");
		}else {
			commit(con);
			System.out.println("L성공");
		}

	return llist;
	}

	public ArrayList<ProCategory> selectMcategory(String selectedL) {

		Connection con = getConnection();
		ArrayList<ProCategory> mlist = pDao.selectMcategory(con,selectedL);

		if(mlist == null || mlist.isEmpty()) {
			rollback(con);
			System.out.println("m실패");
		}else {
			commit(con);
			System.out.println("m성공");
		}
		for(ProCategory p : mlist) {
			System.out.println(p.getPcid());
			System.out.println(p.getPcname());
		}
		return mlist;
	}
	
	

	public ArrayList<ProCategory> selectScategory(String selectedL, String selectedM) {
		Connection con = getConnection();
		ArrayList<ProCategory> slist = pDao.selectScategory(con,selectedL,selectedM);
		if(slist == null || slist.isEmpty()) {
			rollback(con);
			System.out.println("s실패");
		}else {
			commit(con);
			System.out.println("s성공");
		}
		return slist;
	}

	public ArrayList<Product> selectProductList(String category, int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Product> products = pDao.selectProductList(con,category,currentPage , limit);
		if(products.isEmpty() || products == null)
		{
			rollback(con);
			System.out.println("selectProductList 실패");
		}else {
			commit(con);
			System.out.println("selectProductList 성공");
		}
		
		return products;
	}

	public int getListCount() {
		Connection con =getConnection();
		int listCount = pDao.getListCount(con);
		close(con);
		return listCount;
	}
	
	
	

}
