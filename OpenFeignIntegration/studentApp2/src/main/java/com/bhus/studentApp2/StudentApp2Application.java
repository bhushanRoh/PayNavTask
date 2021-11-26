package com.bhus.studentApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentApp2Application.class, args);
	}

}
