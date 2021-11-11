package JDBC1;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadingDataFromXML 
{
	@Test
	public void readfromXML(XmlTest xml) 
	{
		System.out.println();
		String username = xml.getParameter("username");
		System.out.println(username);
		
	}
	@Test
	public void base() 
	{
		System.out.println("Hi fellas");
	}
}


