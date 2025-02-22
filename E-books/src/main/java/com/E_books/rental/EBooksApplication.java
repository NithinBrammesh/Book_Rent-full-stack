package com.E_books.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class EBooksApplication {

	public static void main(String[] args) {

		SpringApplication.run(EBooksApplication.class, args);

		String url = "jdbc:mysql://localhost:3306/e_Books?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "webapp_user";
		String password = "carServicePass";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			System.out.println("✅ Database Connection Successful!");
		} catch (SQLException e) {
			System.out.println("❌ Connection Failed: " + e.getMessage());
		}
	}
	}


