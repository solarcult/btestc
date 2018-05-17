package org.shil.omg.db.connect;

import java.sql.Connection;

import java.sql.DriverManager;

import org.shil.omg.db.info.SeedDB;


/**
 * 数据库连接工具类
 *  
 * @author ShiL
 * 
 * 2018-05-16 23:07:20
 */

public class SeedDBDataBaseManager
{
	public static Connection connection;

	public static Connection getConnection()
	{
		if(connection == null){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://"+SeedDB.IPADDRESS+":3306/"+SeedDB.NAME, SeedDB.USER, SeedDB.PASSWORD);
				connection = conn;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return connection;
	}
	
}
