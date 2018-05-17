package org.shil.omg.application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.shil.omg.db.DuplicateTableDAOImpl;
import org.shil.omg.db.LotteryTableDAOImpl;
import org.shil.omg.db.ShardingTableDAOImpl;
import org.shil.omg.db.ShardingUtil;
import org.shil.omg.db.connect.SeedDBDataBaseManager;

public class SeedTestThread extends Thread {
	
	public static String QUERY_SEED_FROM_TABLE_PREFIX_SQL = "SELECT id, seed FROM seed_";
	public static String QUERY_SEED_FROM_TABLE_PREPOST_SQL = " where status = 0 limit 100";
	
	@Override
	public void run() {
		Random rchange = new Random();
		int changeKey = Math.abs(rchange.nextInt() % ShardingUtil.ShardingTotal);
		Random rtable = new Random();
		
		do {
			PreparedStatement s = null;
			
			int seedtableIndex = Math.abs(rtable.nextInt() % ShardingUtil.ShardingTotal);
			
//			System.out.println(seedtableIndex);
			if(seedtableIndex == changeKey) {
				rtable = new Random();
				changeKey = rchange.nextInt() % ShardingUtil.ShardingTotal;
			}
			
			String querySeedTableSql = QUERY_SEED_FROM_TABLE_PREFIX_SQL+seedtableIndex+QUERY_SEED_FROM_TABLE_PREPOST_SQL;
			
			try {
				s = SeedDBDataBaseManager.getConnection().prepareStatement(querySeedTableSql);
				ResultSet rs = s.executeQuery();
				while(rs.next()) {
					String seed = "isthatme_in_SeedTestThread!";
					long balance =0;
					try {
						long id = rs.getLong(1);
						seed = rs.getString(2);
						balance = SeedTest.testBalanceFromSeed(seed);
						if(balance>0) {
							//is this really happend? omg! omg!
							LotteryTableDAOImpl.lotteryRecord(seed, balance);
							DuplicateTableDAOImpl.errorRecord(seed, "OMG OMG OMG BINGO BINGO : "+balance);
						}else {
							ShardingTableDAOImpl.updateSeedTested2Done(seedtableIndex, id);
						}
						
					}catch(Exception e) {
						DuplicateTableDAOImpl.errorRecord(seed, String.valueOf(balance));
						DuplicateTableDAOImpl.errorRecord(seed, e);
//						System.out.println(this.getName()+this.getId()+" has detected Exception! querysql : "+querySeedTableSql);
//						e.printStackTrace();
					}
				}
			}catch(Exception e) {
				DuplicateTableDAOImpl.errorRecord("SeedTestThread.run()", e);
			}

		}while(true);
	}

	public static void main(String[] args) {
		SeedDBDataBaseManager.getConnection();
		int core = Runtime.getRuntime().availableProcessors();
		System.out.println(core);
		for(int i =0; i<(core/2-1);i++) {
			new SeedTestThread().start();
		}
	}

}
