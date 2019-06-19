package com.dmg.jsp.product.model.dao;

import static com.dmg.jsp.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.dmg.jsp.notice.model.dao.NoticeDao;
import com.dmg.jsp.product.model.vo.ProCategory;
import com.dmg.jsp.product.model.vo.Product;
import com.dmg.jsp.product.model.vo.ProductAttachment;

public class ProductDao {
	private Properties prop;

	public ProductDao() {
		prop = new Properties();

		String filePath = NoticeDao.class.getResource("/config/product-query.properties").getPath();

		try {

			prop.load(new FileReader(filePath));

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public int insertProduct(Connection con, Product product) {
		int result = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		System.out.println("sql1 " + sql);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getCategoryL());
			pstmt.setString(2, product.getCategoryM());
			pstmt.setString(3, product.getCategoryS());
			pstmt.setString(4, product.getPname());
			pstmt.setString(5, product.getPcontent());
			pstmt.setInt(6, product.getPprice());
			pstmt.setInt(7, product.getPweight());
			pstmt.setString(8, product.getPunit());
			pstmt.setString(9,product.getPfile());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			System.out.println("sql2 " + sql);
			System.out.println("결과" + result);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<ProCategory> selectLcategory(Connection con) {

		ArrayList<ProCategory> llist = new ArrayList<ProCategory>();
		Statement stmt = null;
		ResultSet rset = null;
		ProCategory category ;
		String sql = prop.getProperty("selectLlist");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				category = new ProCategory();
				category.setPcid(rset.getString("lid"));
				category.setPcname(rset.getString("ltitle"));
				llist.add(category);
			}

			rset.getString("lid");

		} catch (SQLException e) {
			close(rset);
			close(stmt);
		}
		return llist;
	}

	public ArrayList<ProCategory> selectMcategory(Connection con, String selectedL) {

		PreparedStatement pstmt = null;
		ArrayList<ProCategory> mlist = new ArrayList<>();
		ResultSet rset = null;

		String sql = prop.getProperty("selectMlist");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, selectedL);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				ProCategory category = new ProCategory();
				category.setPcid(rset.getString("mid"));
				category.setPcname(rset.getString("mtitle"));
				mlist.add(category);
			}

		} catch (SQLException e) {

			close(rset);
			close(pstmt);
		}

		return mlist;
	}

	public ArrayList<ProCategory> selectScategory(Connection con, String selectedL, String selectedM) {

		PreparedStatement pstmt = null;
		ArrayList<ProCategory> slist = new ArrayList<>();
		ResultSet rset = null;

		String sql = prop.getProperty("selectSlist");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, selectedL);
			pstmt.setString(2, selectedM);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				ProCategory category = new ProCategory();
				category.setPcid(rset.getString("sid"));
				category.setPcname(rset.getString("stitle"));
				slist.add(category);
			}

		} catch (SQLException e) {

			close(rset);
			close(pstmt);
		}

		return slist;

	}

	public int selectCurrentPid(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = prop.getProperty("selectLastPid");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next())
				result = rset.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}

	public int inserAttachment(Connection con, ArrayList<ProductAttachment> list) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAttachment");
		try {
			for(int i = 0 ; i < list.size();  i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,list.get(i).getPid());
				pstmt.setString(2,list.get(i).getOriginFileName());
				pstmt.setString(3,list.get(i).getChangeFileName());
				pstmt.setString(4, list.get(i).getFilePath());
				int level = 0;
				if(i != 0) level = 1;
				pstmt.setInt(5, level);
				result += pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public ArrayList<Product> selectProductList(Connection con, String category, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<>();
		String sql = prop.getProperty("selectProductList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			int startRow = (currentPage-1) *limit+1;
			int endRow = startRow +limit -1;
			System.out.println(category);
			System.out.println(endRow);
			System.out.println(startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				System.out.println("cateogory : "+category);
				Product p = new Product();
				p.setCategoryL(rset.getString("lid"));
				p.setCategoryM(rset.getString("mid"));
				p.setCategoryS(rset.getString("sid"));
				
				p.setpid(Integer.parseInt(rset.getString("pid")));
				p.setPcontent(rset.getString("pcontent"));
				p.setPname(rset.getString("pname"));
				p.setPprice(Integer.parseInt(rset.getString("pprice")));
				p.setPunit(rset.getString("punit"));
				p.setPweight(Integer.parseInt(rset.getString("pweight")));
				p.setStatus(rset.getString("pstatus"));
				p.setPfile(rset.getString("pfile"));
				
				
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return products;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next())
				listCount = rset.getInt(1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

}
