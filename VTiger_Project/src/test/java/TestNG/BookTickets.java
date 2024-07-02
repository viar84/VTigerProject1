package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTickets
{
	@Test(dataProvider = "dataProvider_BookTicket")
	public void bookTicketsTest(String src,String tgt)
	{
		System.out.println("Book ticket from"+src+"to"+tgt);
	}
	
	@DataProvider
	public Object[][] dataProvider_BookTicket()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "Covai";
		objArr[0][1] = "Kerala";
		
		objArr[1][0] = "Covai";
		objArr[1][1] = "Chennai";
		
		objArr[2][0] = "Covai";
		objArr[2][1] = "Salem";
		return objArr;
		
	}

}
