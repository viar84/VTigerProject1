package DDT;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.bidi.Connection;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;

public class FetchDataFromDatabaseTest  extends BaseClass {

	@Test
	public   void FetchDataFromDatabaseTest() throws SQLException
	{
		 
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","root");
		
		//statement to create query
		Statement state = con.createStatement();
		String Query ="Select * from Student";
		ResultSet result = state.executeQuery(Query);
		while( result.next())
		{
			System.out.println(result.getInt(1)+"\t"+ result.getString(2)+"\t"+ result.getString(3)+"\t"+ result.getString(3));
		}
			
		 
	}

}
