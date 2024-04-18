package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QLLop";
			String user = "sa";
			String password = "sapassword";
			
            Connection con = DriverManager.getConnection(url, user, password);
            
            if(con != null) {
            	System.out.println("Connected!");
            } else System.out.println("Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
