package org.shil.omg.db;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.shil.omg.db.connect.LotteryDBDataBaseManager;

public class DuplicateTableDAOImpl {
	
	public static final String CREATE_DUPLICATE_TABLE = "CREATE TABLE duplicate(\n" +
            "    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "    `seed` VARCHAR(250) NOT NULL,\n" +
            "    `error` VARCHAR(2048) NOT NULL,\n" +
            "    `time` DATETIME NOT NULL,\n" +
            "    PRIMARY KEY (`id`) \n" +
            ")\n";

	public static void createTable() {
		try {
			LotteryDBDataBaseManager.getConnection().createStatement().executeUpdate(CREATE_DUPLICATE_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		createTable();
		errorRecord("sssssssss", "i am here");
		errorRecord("eroro", new RuntimeException("abc"));
	}
	
	public static void errorRecord(String seed,Exception e) {
		PreparedStatement d = null;
		try {
			StringWriter sw = new StringWriter();   
            e.printStackTrace(new PrintWriter(sw, true));
            d = LotteryDBDataBaseManager.getConnection().prepareStatement("INSERT INTO duplicate (seed,error,time) VALUES (? , ? , now())");
            d.setString(1, seed);
            d.setString(2, sw.toString());
            d.executeUpdate();
            d.close();
		}catch(Exception ee) {
			e.printStackTrace();
		}finally {
			try {
				if(d!=null) d.close();
			} catch (Exception ex) {
//				e.printStackTrace();
			}
		}
	}
	
	public static void errorRecord(String seed,String sth) {
		PreparedStatement d = null;
		try {
            d = LotteryDBDataBaseManager.getConnection().prepareStatement("INSERT INTO duplicate (seed,error,time) VALUES (? , ? , now())");
            d.setString(1, seed);
            d.setString(2, sth);
            d.executeUpdate();
            d.close();
		}catch(Exception ee) {
			
		}finally {
			try {
				if(d!=null) d.close();
			} catch (Exception ex) {
//				e.printStackTrace();
			}
		}
	}

}
