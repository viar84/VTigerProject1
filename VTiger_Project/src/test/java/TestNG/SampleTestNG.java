package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestNG
{
	@Test(priority = -1,invocationCount = 3)
	public void createProduct()
	{
		System.out.println("Product is created");
		//Assert.fail();
	}
	
	@Test(priority = 0,dependsOnMethods ="createProduct" )
	
	public void modifyProduct()
	{
		System.out.println("Product is modified");
	}
	
	@Test(priority = 1,enabled = false)
	public void deleteProduct()
	{
		System.out.println("Product is deleted");
	}

}
