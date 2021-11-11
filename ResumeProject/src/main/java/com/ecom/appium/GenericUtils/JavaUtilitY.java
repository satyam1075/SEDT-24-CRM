package com.ecom.appium.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtilitY 
{
	
	/**
	 * generates random data
	 * @return
	 */
public static String getRandomData() 
{
	Random r = new Random();
	int ran = r.nextInt();
	return ""+ran;
	
}
/**
 * this method is used to generate current date
 */
public static String getCurrentdate() 
{
	Date d = new Date();
	String currentDate = d.toString();
	return currentDate;
	}

}
