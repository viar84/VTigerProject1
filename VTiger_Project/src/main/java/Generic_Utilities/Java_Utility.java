package Generic_Utilities;

import java.util.Random;

public class Java_Utility
{
	/**
	 * It is used to generate the randam number within the range of 1000
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
