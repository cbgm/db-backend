package de.christian.api.dao.test;
import java.sql.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserInit {
 
	public static void main(String[] args) {
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/webdb";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			
			String password = "0000";
			String username = "c";
			String role = "ADMIN";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			
			Statement st = conn.createStatement();
			
			st.executeUpdate("INSERT INTO user (username, password) "
					+"VALUES ('" + username +  "', '" + hashedPassword +  "')");
			st.executeUpdate("INSERT INTO user_roles (username, role) "
					+"VALUES ('" + username +  "', '" + role +  "')");
			
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		
	}
}