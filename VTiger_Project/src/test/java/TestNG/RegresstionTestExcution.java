package TestNG;

import org.testng.annotations.Test;

public class RegresstionTestExcution {
	@Test 
	public void createProduct()
	{
		System.out.println("Product is created");
		//Assert.fail();
	}
	
	@Test 
	
	public void modifyProduct()
	{
		System.out.println("Product is modified");
	}
	
	@Test 
	public void deleteProduct()
	{
		System.out.println("Product is deleted");
	}
}
