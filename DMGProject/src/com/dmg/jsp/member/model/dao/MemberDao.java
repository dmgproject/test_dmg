package com.dmg.jsp.member.model.dao;

import static com.dmg.jsp.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.dmg.jsp.member.model.vo.Member;
import com.dmg.jsp.member.model.exception.MemberException;

public class MemberDao {
	
	private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		
		String filePath
			= MemberDao.class.getResource("/config/member-query.properties")
				.getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, Member m) throws MemberException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("insertMember");

			pstmt = con.prepareStatement(sql);
			
			//userId,userPwd,userName,userNickName,gender,
			//age,email,phone,address, (enrollDate,status)
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());

			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());
			
			result = pstmt.executeUpdate();
				
		}  catch (SQLException e) {
			throw new MemberException(e.getMessage());
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public Member selectMember(Connection con, Member m) throws MemberException {
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			String sql = prop.getProperty("selectMember");
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = new Member();
				result.setUserId(m.getUserId());
				result.setUserPwd(m.getUserPwd());
				result.setUserName(rset.getString("username"));
				result.setEmail(rset.getString("email"));
				result.setPhone(rset.getString("phone"));
				result.setAddress(rset.getString("address"));
				result.setStatus(rset.getString("status"));
			}
		} catch(Exception e) {

			throw new MemberException(e.getMessage());
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection con, Member m) throws MemberException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {

			String sql = prop.getProperty("updateMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
		
		} catch ( SQLException e) {
			throw new MemberException(e.getMessage());
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection con, String userId, String userPwd) throws MemberException {
		/*
		 *  DMG MEMBER 테이블의 STATUS를 N으로 수정합니다.
		 *  회원 탈퇴 신청시 바로 삭제되지 않고, 데이터를 유지하다 삭제 하기 위함.
		 */
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("deleteMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch ( SQLException e) {

			throw new MemberException(e.getMessage());
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int idDupCheck(Connection con, String id) {
		int result = -1;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("duplicateMember");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int nickDupCheck(Connection con, String nick) {
		int result = -1;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("duplicateNick");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Member passwordcheck(Connection con, Member m){
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			
			String sql = prop.getProperty("mailcheck");
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new Member();

				result.setUserId(m.getUserId());
				//result.setUserPwd(m.getUserPwd());

				//result.setUserName(rset.getString(3));
				result.setEmail(rset.getString("email"));
				//result.setPhone(rset.getString("phone"));
				//result.setAddress(rset.getString("address"));
				//result.setStatus(rset.getString("status"));
			}
		} catch(Exception e) {

			System.out.println(e + "또 에러");
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int passwordupdate(Connection con, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {

			String sql = prop.getProperty("updatePassword");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());

			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
		
		} catch ( SQLException e) {
			System.out.println(e);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String findid(Connection con, String userName, String email) throws MemberException {

		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		try {
			String sql = prop.getProperty("findid");
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, email);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result =rset.getString("userid");

			}
		} catch(Exception e) {

			throw new MemberException(e.getMessage());
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
}
