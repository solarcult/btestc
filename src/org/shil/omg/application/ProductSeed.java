package org.shil.omg.application;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.Wallet;

import com.google.common.base.Joiner;

public class ProductSeed {

	public static String productSeed() {
		Wallet wallet = new Wallet(MainNetParams.get());
//		System.out.println(wallet);
		return Joiner.on(" ").join(wallet.getKeyChainSeed().getMnemonicCode());
	}
	
	public static void main(String[] args) {
		System.out.println(productSeed());
	}

}
