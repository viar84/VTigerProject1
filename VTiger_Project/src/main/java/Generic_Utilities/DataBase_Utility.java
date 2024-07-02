package Generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBase_Utility
{
	public void databaseconnection() throws SQLException
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
	}
	public void databaseClose() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","root");
		con.close();
	}
}
