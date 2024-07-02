package BasicAssignemnt1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAssignment {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		String CName="Australia";
		String country = driver.findElement(By.xpath("//span[text()='"+CName+"']")).getText();

        String gold = driver.findElement(By.xpath("//span[text()='"+CName+"']/../following-sibling::div[1]/span/span")).getText();
        String silver = driver.findElement(By.xpath("//span[text()='"+CName+"']/../following-sibling::div[2]/span/span")).getText();
        String bronze = driver.findElement(By.xpath("//span[text()='"+CName+"']/../following-sibling::div[3]/span/span")).getText();
        String total = driver.findElement(By.xpath("//span[text()='"+CName+"']/../following-sibling::div[4]/span/span")).getText();
        
        System.out.println("Country Name"+"--"+country);      
        System.out.println("Gold"+"--"+gold);
        System.out.println("Silver"+"--"+silver);
        System.out.println("Bronz"+"--"+bronze);
        System.out.println("total"+"--"+total);
	}

}
