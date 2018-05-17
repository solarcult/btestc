package org.shil.omg.db.connect;

import java.sql.Connection;

import java.sql.DriverManager;

import org.shil.omg.db.info.LotteryDB;


/**
 * 数据库连接工具类
 *  
 * @author ShiL
 * 
 * 2018-05-16 23:07:20
 */

public class LotteryDBDataBaseManager
{
	public static Connection connection;

	public static Connection getConnection()
	{
		if(connection == null){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://"+LotteryDB.IPADDRESS+":3306/"+LotteryDB.NAME, LotteryDB.USER, LotteryDB.PASSWORD);
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
