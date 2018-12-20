package org.shil.omg.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Wordlist {
	
	public static String[] wordlist = new String[2048];
	static {
		try {
			String filepath = Wordlist.class.getClassLoader().getResource("org/bitcoinj/crypto/mnemonic/wordlist/english.txt").getFile();
			BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
			for(int i=0;i<wordlist.length;i++) {
				String word = br.readLine();
				wordlist[i] = word;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}
