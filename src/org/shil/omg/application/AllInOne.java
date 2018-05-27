package org.shil.omg.application;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.store.MySQLFullPrunedBlockStore;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.shil.omg.db.DuplicateTableDAOImpl;
import org.shil.omg.db.LotteryTableDAOImpl;
import org.shil.omg.db.info.BTC;

import com.google.common.base.Joiner;

public class AllInOne {

	protected static MySQLFullPrunedBlockStore myBTCconnect;
	
	static{
		try {
			myBTCconnect = new MySQLFullPrunedBlockStore(MainNetParams.get(), 1000, BTC.IPADDRESS, BTC.NAME, BTC.USER, BTC.PASSWORD); 
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("init database connection myBTCconnect error: ", e);
		}
	}
	
	public static void guess() {
//		long start = System.currentTimeMillis();
		try {
			Wallet wallet = new Wallet(MainNetParams.get());
			String seed = Joiner.on(" ").join(wallet.getKeyChainSeed().getMnemonicCode());
			DeterministicSeed dseed = new DeterministicSeed(seed, null, "", 0);
			Wallet tw = Wallet.fromSeed(MainNetParams.get(), dseed);
			tw.setUTXOProvider(myBTCconnect);
			long balance = tw.getBalance().getValue();
			
			if(balance>0) {
				//is this really happend? omg! omg!
				LotteryTableDAOImpl.lotteryRecord(seed, balance);
				DuplicateTableDAOImpl.errorRecord(seed, "OMG OMG OMG BINGO BINGO : "+balance);
			}
//			System.out.println(balance + seed);
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("guess has error: ", e);
		}
		
//		long end = System.currentTimeMillis();
//		System.out.println(end-start);
	}
	
	public static void main(String[] args) {
		guess();
	}

}
