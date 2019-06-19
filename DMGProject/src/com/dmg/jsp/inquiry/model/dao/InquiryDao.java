package com.dmg.jsp.inquiry.model.dao;

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

import com.dmg.jsp.inquiry.model.vo.Inquiry;

public class InquiryDao {
	
	private Properties prop;
	
	public InquiryDao() {
		prop = new Properties();
		
		String filePath = InquiryDao.class.
				getResource("/config/inquiry-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public ArrayList<Inquiry> selectList(Connection con, 
			int currentPage, int limit) {
		
		ArrayList<Inquiry> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의 번호
			// 2. 첫 행의 번호
			
			int startRow = (currentPage - 1) * limit + 1; // 1, 11
			int endRow = startRow + limit - 1; // 10, 20
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Inquiry>();
			
			while(rset.next()) {
				Inquiry i = new Inquiry();
				i.setIno(rset.getInt("INO"));
				i.setItype(rset.getInt("ITYPE"));
				i.setItitle(rset.getString("ITITLE"));
				i.setIcontent(rset.getString("ICONTENT"));
				i.setIwriter(rset.getString("IWRITER"));
				i.setIcount(rset.getInt("ICOUNT"));
				i.setIdate(rset.getDate("IDATE"));
				i.setInquiryfile(rset.getString("INQUIRYFILE"));
				
				list.add(i);
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection con) {
		// 총 게시글 수
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int insertInquiry(Connection con, Inquiry i) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertInquiry");
		System.out.println(sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, i.getItitle());
			pstmt.setString(2, i.getIcontent());
			pstmt.setString(3, i.getIwriter());
			pstmt.setString(4, i.getInquiryfile());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Inquiry selectOne(Connection con, int ino) {
		Inquiry i = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ino);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				i = new Inquiry();
				
				i.setIno(ino);
				i.setItype(1);
				i.setItitle(rset.getString("ITITLE"));
				i.setIcontent(rset.getString("ICONTENT"));
				i.setIwriter(rset.getString("USERNAME"));
				i.setIwriterId(rset.getString("IWRITER"));
				i.setIcount(rset.getInt("ICOUNT"));
				i.setInquiryfile(rset.getString("INQUIRYFILE"));
				i.setIdate(rset.getDate("IDATE"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return i;
	}

}







