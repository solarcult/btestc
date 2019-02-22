package org.shil.omg.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.shil.omg.db.connect.LotteryDBDataBaseManager;

public class LotteryTableDAOImpl {
	
	public static final String CREATE_LOTTERY_TABLE = "CREATE TABLE lottery(\n" +
            "    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "    `seed` VARCHAR(250) NOT NULL,\n" +
            "    `balance` BIGINT(20) NOT NULL DEFAULT 0,\n" +
            "    `time` DATETIME NOT NULL,\n" +
            "    PRIMARY KEY (`id`)\n" +
            ")\n";

	
	public static void createTable() {
		try {
			LotteryDBDataBaseManager.getConnection().createStatement().executeUpdate(CREATE_LOTTERY_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		createTable();
		lotteryRecord("is this true", 100);
	}
	
	public static void lotteryRecord(String seed,long balance) {
		
		LotteryFileUtil.write2disk(seed,String.valueOf(balance));
		
		PreparedStatement d = null;
		try {
            d = LotteryDBDataBaseManager.getConnection().prepareStatement("INSERT INTO lottery (seed,balance,time) VALUES (? , ? , now())");
            d.setString(1, seed);
            d.setLong(2, balance);
            d.executeUpdate();
            d.close();
		}catch(Exception e) {
			e.printStackTrace();
			DuplicateTableDAOImpl.errorRecord(seed, String.valueOf(balance));
			DuplicateTableDAOImpl.errorRecord(seed, e);
		}finally {
			try {
				if(d!=null) d.close();
			} catch (Exception ex) {
//				e.printStackTrace();
			}
		}
	}

}
