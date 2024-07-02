package DDT;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		//load sql database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		//connect database
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","root");
		
		//statement to create query
		Statement state = con.createStatement();
		String Query ="insert into  student(first_name,last_name,address)values('ananya','av','cbe'),('arun','av','cbe')";
		int result = state.executeUpdate(Query);
		if(result==1)
		{
			System.out.println("Data inserted");
		}
		else
			System.out.println("Data not inserted");
			
		con.close();

	}

}
