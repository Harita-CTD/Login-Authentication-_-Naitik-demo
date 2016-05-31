package com.ibm.login;

import java.sql.*;

public class LoginDao {
	public static final String url = "jdbc:mysql://localhost:3306/ctd";

	public static boolean validate(String name, String pass) {
		boolean status = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root",
					"password");
			PreparedStatement ps = connection
					.prepareStatement("select * from userdetails where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (SQLException | ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return status;

	}

}
