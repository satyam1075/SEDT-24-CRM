package TestScripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadFromJSON 
{
	@Test
	public String getDataFromJson(String jsonkey) throws Throwable, ParseException 
	{
		
		FileReader reader = new FileReader(".//Data//CommonData.json");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jobject = (JSONObject)object;
		return jobject.get(jsonkey).toString();
		
	}
	
	@Test
	public void execute() throws Throwable, Throwable 
	{
		String device = getDataFromJson("deviceName");
		System.out.println(device);
	}
}
