package org.shil.omg.application;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.store.FullPrunedBlockStore;
import org.bitcoinj.store.MySQLFullPrunedBlockStore;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.shil.omg.db.DuplicateTableDAOImpl;
import org.shil.omg.db.info.BTC;

public class SeedTest {
	
	public static MySQLFullPrunedBlockStore myBTCconnect;
	
	static{
		try {
			myBTCconnect = new MySQLFullPrunedBlockStore(MainNetParams.get(), 1000, BTC.IPADDRESS, BTC.NAME, BTC.USER, BTC.PASSWORD); 
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("init myBTCconnect error", e);
		}
	}
	
	public static long testBalanceFromSeed(String seedstr) throws Exception {
		long balance = 0;
		try {
			DeterministicSeed seed = new DeterministicSeed(seedstr, null, "", 0);
			Wallet wallet = Wallet.fromSeed(MainNetParams.get(), seed);
			FullPrunedBlockStore vStore = myBTCconnect;
			wallet.setUTXOProvider(vStore);
			balance = wallet.getBalance().getValue();
		} catch (Exception e) {
			System.out.println("SeedTest.testBalanceFromSeed has error"+seedstr);
			throw e;
		}
		return balance;
	}

	public static void main(String[] args) {
		
		try {
			DeterministicSeed seed = new DeterministicSeed("page unaware web cotton tenant comic vocal yellow cool talent erode derive", null, "", 0);
			Wallet wallet = Wallet.fromSeed(MainNetParams.get(), seed);
			FullPrunedBlockStore vStore = new MySQLFullPrunedBlockStore(MainNetParams.get(), 1000, BTC.IPADDRESS, BTC.NAME, BTC.USER, BTC.PASSWORD);
			wallet.setUTXOProvider(vStore);
			System.out.println(wallet.getBalance().getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
