package com.gss.web.common.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	private String authNumber;
	@Value("${email.username}")
	private String userEmail;
	@Async
	public String sendMail(String email) {
		makeRandomNumber();
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom(userEmail); // NAVER, DAUM, NATE일 경우 넣어줘야 함
		simpleMessage.setTo(email);
		simpleMessage.setSubject("GSS 이메일 인증");
		simpleMessage.setText("인증번호:"+authNumber);
		javaMailSender.send(simpleMessage);
		return authNumber;
	}
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		authNumber = String.valueOf(checkNum);
	}
}
