package com.hotfix.email.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MultipleEmailConfig {
	@Value("${spring.gmail_mail.host}")
	private String gmailhHost;
    @Value("${spring.gmail_mail.port}")
	private Integer port;
    @Value("${spring.gmail_mail.transport.protocol}")
	private String smtp;
    @Value("${spring.gmail_mail.smtp.starttls.enable}")
   	private String starttls;
    @Value("${spring.gmail_mail.smtp.auth}")
   	private String gmailAuth;
    @Value("${spring.gmail_mail.username}")
   	private String gmailUserName;
    @Value("${spring.gmail_mail.password}")
   	private String gmailPassword;
    @Value("${spring.amazon_mail.host}")
	private String amazonHost;
    @Value("${spring.amazon_mail.port}")
	private Integer amazonPort;
    @Value("${spring.amazon_mail.transport.protocol}")
	private String amazonsmtp;
    @Value("${spring.amazon_mail.smtp.starttls.enable}")
   	private String amazonStarttls;
    @Value("${spring.amazon_mail.username}")
   	private String amazonUserName;
    @Value("${spring.amazon_mail.password}")
   	private String amazonPassword;
    @Value("${spring.amazon_mail.smtp.auth}")
   	private String amazonAuth;
    
    @Bean(name = "gmailJMSTemplate")
    public JavaMailSender getGmailJavaMailSender(@Qualifier("gmailJMSProperties")Properties properties) {
    	   JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	   mailSender.setPort(port);
    	   mailSender.setHost(gmailhHost);
    	   mailSender.setUsername(gmailUserName);
    	   mailSender.setPassword(gmailPassword);
    	   mailSender.setJavaMailProperties(properties);
          return mailSender;
	} 
	@Bean(name = "amazonJMSTemplate")
	public JavaMailSender getAmazonJavaMailSender(@Qualifier("gmailJMSProperties")Properties properties) {
		   JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 	   mailSender.setPort(port);
	 	   mailSender.setUsername(gmailUserName);
	 	   mailSender.setPassword(gmailPassword);
	 	   mailSender.setJavaMailProperties(properties);
       return mailSender;
	}
	@Bean(name = "gmailJMSProperties")
	public Properties getGmailJavaMailSenderPropeties() {
		    Properties props = new Properties();
	       // properties.setProperty("mail.transport.protocol",smtp);
	        //properties.setProperty("mail.smtp.auth", "false");
		    props.setProperty("mail.smtp.starttls.enable", starttls);
		    props.put("mail.smtp.host", "127.0.0.1");
	        props.put("mail.smtp.port", "25");
	        props.put("mail.debug", "true");
	        return props;
   }
	@Bean(name = "amazonJMSProperties")
	public Properties getAmazonJavaMailSenderPropeties() {
		    Properties properties = new Properties();
	        properties.setProperty("mail.transport.protocol",amazonsmtp);
	        properties.setProperty("mail.smtp.auth",amazonAuth);
	        properties.setProperty("mail.smtp.starttls.enable", amazonStarttls);
	        return properties;
   }
}