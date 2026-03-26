package com.Couse_man.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	
		public static Connection getConnection() throws SQLException{
		String url ="jdbc:mysql://localhost:3306/course_mang";
		String username = "root";
		String password = "1234" ;
		
		
		return DriverManager.getConnection(url,username,password);
	}

}
