package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;


public class ExecuteUpdate extends SQLException
{
	Connection con =null;
	@Test
	public void executeupdate() throws SQLException 
	{
		try {
			//Register the database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
					
			//Establish a connection with the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
					
			//issue create statement
			Statement stat = con.createStatement();
			
			int result=stat.executeUpdate("insert into customer vlues('name1','lastname1','place1');");
			
			if(result == 1) 
			{
				System.out.println("Updated sucessfully");
			}
			else 
			{
				System.out.println("query failed");
			}
		}
		
		catch(Exception e)
		{
			
		}	
		finally
		{
			con.close();
		}
	}
	
		
}

