package com.hotfix.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;


@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"com.google.email.service"})
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("gmailJMSTemplate")
    public JavaMailSender gmailJMSTemplate;
	@Autowired
	@Qualifier("amazonJMSTemplate")
    public JavaMailSender amazonJMSTemplate;
    public static void main(String[] args) throws Exception {
         SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
   
   }
}