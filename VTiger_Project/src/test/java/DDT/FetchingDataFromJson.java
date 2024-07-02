package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJson {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		
	File fil = new File("./src\\test\\resources\\Testdata.json");
	ObjectMapper jsondata = new ObjectMapper();
	JsonNode Node = jsondata.readTree(fil);
	String url = Node.get("url").asText();
	
	ChromeDriver driver = new ChromeDriver();
	driver.get(url);
	driver.findElement(By.id("user-name")).sendKeys(Node.get("username").asText());
	driver.findElement(By.id("password")).sendKeys(Node.get("password").asText());	
	}

}
