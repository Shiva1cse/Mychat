package chatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
public Connection CreateConenction()throws SQLException, ClassNotFoundException
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/id1795014_a6701781_android","id1795014_a6701781_anduser","shiva");  	return con;
}
}