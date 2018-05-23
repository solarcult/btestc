package org.shil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.shil.omg.db.DuplicateTableDAOImpl;
import org.shil.omg.db.LotteryTableDAOImpl;

import com.google.common.base.Joiner;

public class AutoReloadBTCDB {

	public static void main(String[] args) {
		final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
			            MainDBWalletAppKit kit = new MainDBWalletAppKit(MainNetParams.get(), new File("c:\\walletest"), "tbt");
			            kit.startAsync();
			            kit.awaitRunning();
			            Wallet kw = kit.wallet();
			            DeterministicSeed seed2 = kw.getKeyChainSeed();
			            String words = Joiner.on(" ").join(seed2.getMnemonicCode());
			            long balance = kit.wallet().getBalance().getValue();
			            if(balance>0) {
			            	LotteryTableDAOImpl.lotteryRecord(words, balance);
			            }
			            DuplicateTableDAOImpl.errorRecord(dateformat.format(Calendar.getInstance().getTime()),"auto reload starting!");
					}catch(Exception e) {
						DuplicateTableDAOImpl.errorRecord("inner auto thread run ()", e);
					}			
				}
			}).start();
			
			try {
				Thread.sleep(12 * 30 * 24 * 3600 * 1000);
			}catch(Exception e) {
				DuplicateTableDAOImpl.errorRecord("wake up? should not happened in one year !", e);

			}
		}
	}

}
