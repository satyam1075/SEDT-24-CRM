package com.ecom.appium.GenericUtils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.remote.service.DriverCommandExecutor;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtilities 
{
	static Connection con = null;
	static ResultSet result = null;
	
	public void connectToDatabase()  throws Throwable
	{
		Driver driverRef;
		
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql//localhost:3306/sa","root","root");		
		
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	public static ResultSet executeQuery(String query) throws SQLException 
	{
		result = con.createStatement().executeQuery(query);
		return result;
		
	}
	
	public static String executeQueryAndGetData(String query,String columnName,String expectedData) throws Throwable 
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		
		while(result.next()) 
		{
			
			if(result.getString(columnName).equals(expectedData)) 
			{
				flag = true;
				break;
			}
		}
		if (flag) 
		{
			System.out.println(expectedData+ "==> data verified in data base table");
			return expectedData;
		}
		else 
		{
			System.out.println(columnName+"==> data not verified in database table");
			return expectedData;
		}
		
	}
}