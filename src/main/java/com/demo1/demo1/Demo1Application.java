package com.demo1.demo1;

import com.demo1.demo1.entity.Users;
import com.demo1.demo1.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application  {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
