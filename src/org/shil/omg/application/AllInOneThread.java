package org.shil.omg.application;

public class AllInOneThread extends Thread{
	
	@Override
	public void run() {
		do {
//			AllInOne.guess();
			AllInOne.randomSeedsGuess();
		}while(true);
	}

	public static void main(String[] args) {
		int core = Runtime.getRuntime().availableProcessors();
		for(int i =0; i<core;i++) {
			new AllInOneThread().start();
		}
	}

}
