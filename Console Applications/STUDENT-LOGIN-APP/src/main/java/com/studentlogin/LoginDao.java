package com.studentlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class LoginDao 
{
	public boolean insert(User user) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demodb",
                "root", "sakthi1617");
		String query = "insert into Login values(?,?)";
		PreparedStatement st = c.prepareStatement(query);
		st.setString(1,user.getUserName());
		st.setString(2, user.getPassword());
		return (st.executeUpdate()==1);

	}
}
