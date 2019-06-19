package com.dmg.jsp.member.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmg.jsp.member.model.service.MemberService;
import com.dmg.jsp.member.model.vo.Member;


@WebServlet("/passmail.me")
public class PasswordMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PasswordMail() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("id");
        String email = request.getParameter("email");
        
        //먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
        Member m = new Member(memberId);
        MemberService ms = new MemberService();
        m = ms.memberLogin(m);
        if(m==null || !m.getEmail().equals(email))
        {
            request.setAttribute("msg", "아이디나 이메일 정보가 맞지 않습니다");
            request.setAttribute("loc", "/member/searchPw");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
            return;
        }
        
                //mail server 설정
                String host = "smtp.naver.com";
                String user = "zuzu_zam@naver.com"; //자신의 네이버 계정
                String password = "zaq1xsw2!";//자신의 네이버 패스워드
                
                //메일 받을 주소
                String to_email = m.getEmail();
                
                //SMTP 서버 정보를 설정한다.
                Properties props = new Properties();
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", 465);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.ssl.enable", "true");
                
                //인증 번호 생성기
                StringBuffer temp =new StringBuffer();
                Random rnd = new Random();
                for(int i=0;i<10;i++)
                {
                    int rIndex = rnd.nextInt(3);
                    switch (rIndex) {
                    case 0:
                        // a-z
                        temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                        break;
                    case 1:
                        // A-Z
                        temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                        break;
                    case 2:
                        // 0-9
                        temp.append((rnd.nextInt(10)));
                        break;
                    }
                }
                String AuthenticationKey = temp.toString();
                System.out.println(AuthenticationKey);
                
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });
                
                //email 전송
                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(user, "DMG.COM"));
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
                    
                    //메일 제목
                    msg.setSubject("안녕하세요 DMG.COM 인증 메일입니다.");
                    //메일 내용
                    msg.setText("인증 번호는 :"+temp);
                    
                    Transport.send(msg);
                    System.out.println("이메일 전송");
                    
                }catch (Exception e) {
                    e.printStackTrace();// TODO: handle exception
                }
                HttpSession saveKey = request.getSession();
                saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
                //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
                request.setAttribute("id", memberId);
                request.getRequestDispatcher("/views/member/passwordedit.jsp").forward(request, response);
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
