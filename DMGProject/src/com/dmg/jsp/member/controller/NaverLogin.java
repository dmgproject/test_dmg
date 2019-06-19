package com.dmg.jsp.member.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dmg.jsp.member.model.vo.Member;

public class NaverLogin {

	
	public NaverLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String[] NaverLogins(String access_token) {
		String[] obk = new String[2];
		 	String token = access_token;// 네이버 로그인 접근 토큰;
	        String header = "Bearer " + token; // Bearer 다음에 공백 추가
	        try {
	        	System.out.println("naverLogin 입성");
	            String apiURL = "https://openapi.naver.com/v1/nid/me";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Authorization", header);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	            JSONParser parsing = new JSONParser();
		    	Object obj = parsing.parse(response.toString());
		    	JSONObject jsonobj = (JSONObject)obj;
		    	JSONObject responseObj = (JSONObject)jsonobj.get("response");
		    	String id = (String)responseObj.get("id");
		    	String email = (String)responseObj.get("email");
		    	System.out.println(id);
		    	System.out.println(email);
		    	obk[0] = id;
		    	obk[1] = email;



	            /*
	            JSONParser parsing = new JSONParser();
	            Object obj = parsing.parse(res.toString());
	            JSONObject jsonobj = (JSONObject) obj;
	            JSONObject responseObj = (JSONObject)jsonobj.get("response");
	            System.out.println(responseObj);
	            String email = (String)responseObj.get("email");
	            System.out.println(email);
	            //String id = (String)responseObj.get("id");
	            //System.out.println("id");
	             */
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    	return obk;
	    }

	
}
