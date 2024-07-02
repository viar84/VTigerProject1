package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility 
{
	/**
	 * Its used to return the property value from the property file based on key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getKeyAndValueData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\CommonData.properties");
		Properties prop  = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
