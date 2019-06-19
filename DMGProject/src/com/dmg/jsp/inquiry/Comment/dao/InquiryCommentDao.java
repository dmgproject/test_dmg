package com.dmg.jsp.inquiry.Comment.dao;

import static com.dmg.jsp.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dmg.jsp.inquiry.Comment.model.vo.InquiryComment;

public class InquiryCommentDao {

	private Properties prop = new Properties();
	
	public InquiryCommentDao() {
		String filePath =
				InquiryCommentDao.class.
				getResource("/config/comment-query.properties").getPath();
		try {
			
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection con, InquiryComment ico) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		System.out.println(sql);
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, ico.getIno());
			pstmt.setString(2, ico.getCcontent());
			pstmt.setString(3, ico.getCwriter());
			
			if(ico.getRefcno() > 0) {
				pstmt.setInt(4, ico.getRefcno());
			}else {
				pstmt.setNull(4, java.sql.Types.NULL);
			}
			
			pstmt.setInt(5, ico.getClevel());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<InquiryComment> selectList(Connection con, int ino) {
		ArrayList<InquiryComment> clist = null;
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, ino);
			
			rset = pstmt.executeQuery();
			
			clist = new ArrayList<InquiryComment>();
			while(rset.next()) {
				InquiryComment ico = new InquiryComment();
				
				ico.setCno(rset.getInt("CNO"));
				ico.setIno(ino);
				ico.setCcontent(rset.getString("CCONTENT"));
				ico.setCwriter(rset.getString("USERNAME"));
				ico.setCwriterId(rset.getString("CWRITER"));
				ico.setCdate(rset.getDate("CDATE"));
				ico.setRefcno(rset.getInt("REF_CNO"));
				ico.setClevel(rset.getInt("CLEVEL"));
				
				clist.add(ico);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		
		
		
		return clist;
	}
	
	
	
	

}
