package org.shil.omg.application;

import org.shil.omg.db.ShardingTableDAOImpl;
import org.shil.omg.db.connect.LotteryDBDataBaseManager;

public class ProductSeedThread extends Thread {

	@Override
	public void run() {
		do {
			String seed = ProductSeed.productSeed();
			ShardingTableDAOImpl.insertSeedTested(seed);
		}while(true);
	}

	public static void main(String[] args) {
		LotteryDBDataBaseManager.getConnection();
		int core = Runtime.getRuntime().availableProcessors();
		System.out.println(core);
		for(int i =0; i<2;i++) {
			new ProductSeedThread().start();
		}
	}

}
