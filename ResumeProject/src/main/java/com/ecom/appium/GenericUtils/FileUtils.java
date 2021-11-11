package com.ecom.appium.GenericUtils;

	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;

public class FileUtils 
{
	/*
	 *  author @Roy
	 */
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyeyValue(String key) throws IOException 
	{
		FileInputStream file = new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
		
	}
	
	/**
	 * 
	 * @param jsonKey
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public String getDataFromJson(String jsonKey) throws IOException, ParseException 
	{
		
		
		FileReader reader = new FileReader(IpathConstant.JSON_FILEPATH);
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonobject =(JSONObject) object;
		String value = jsonobject.get(jsonKey).toString();
		return value;
		
	}
	
}
