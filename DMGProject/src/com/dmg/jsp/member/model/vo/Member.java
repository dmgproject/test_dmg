package com.dmg.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{

	private static final long serialVersionUID = 100000L;
	
	private String userId; // 사용자 아이디
	private String userPwd; // 사용자 비밀번호
	private String userName; // 사용자 이름
	//private String userNickName; // 사용자 닉네임
	//private String gender; // 성별
	//private int age; // 나이
	private String email; // 이메일
	private String phone; // 연락처
	private String address; // 주소
	private Date enrollDate; // 가입일(java.sql.Date)
	private String status; // 회원의 상태 ('Y', 'N', 'A') 가입상태 탈퇴상태 어드민
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// 로그인에 사용
	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	

	
	public Member(String userId) {
		super();
		this.userId = userId;
	}


	public Member(String userId, String userPwd, String userName,
			String email, String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	/*
	// 회원가입 창에서 실제로 받을 변수들. status 와 enrollDate 제외
	public Member(String userId, String userPwd, String userName, String userNickName, String gender, int age,
			String email, String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickName = userNickName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	 */
	


	/*
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNickName="
				+ userNickName + ", gender=" + gender + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
	*/
	
	


	public Member(String id, String email2, String email3) {
		super();
		this.userId = id;
		this.userName = email2;
		this.email = email3;
	}


	public String getUserId() {
		return userId;
	}



	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", enrollDate=" + enrollDate + ", status=" + status
				+ "]";
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserPwd() {
		return userPwd;
	}



	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	/*
	public String getUserNickName() {
		return userNickName;
	}



	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}


	*/
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
