package org.shil.omg.db.connect;

import java.sql.Connection;

import java.sql.DriverManager;

import org.shil.omg.db.info.BTC;


/**
 * 数据库连接工具类
 *  
 * @author ShiL
 * 
 * 2007-2-8 1:33:20
 */

public class BTCDataBaseManager
{
	public static Connection connection;

	public static Connection getConnection()
	{
		if(connection == null){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://"+BTC.IPADDRESS+":3306/"+BTC.NAME, BTC.USER, BTC.PASSWORD);
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
