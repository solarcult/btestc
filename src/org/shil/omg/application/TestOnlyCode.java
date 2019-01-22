package org.shil.omg.application;

import org.shil.omg.db.DuplicateTableDAOImpl;

public class TestOnlyCode {
	
	public static void main(String[] args) {

		String[] seeds = new String[12];
		seeds[0] = Wordlist.wordlist[425];
		seeds[1] = Wordlist.wordlist[251];
		seeds[2] = Wordlist.wordlist[812];
		seeds[3] = Wordlist.wordlist[1534];
		seeds[4] = Wordlist.wordlist[1934];
		seeds[5] = Wordlist.wordlist[1602];
		seeds[6] = Wordlist.wordlist[1067];
		seeds[7] = Wordlist.wordlist[1478];
		seeds[8] = Wordlist.wordlist[1167];
		seeds[9] = Wordlist.wordlist[755];
		seeds[10] = Wordlist.wordlist[877];
		seeds[11] = Wordlist.wordlist[1082];

		new Thread(() -> {
			for (int i = 0; i < 2; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 2; i < 4; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 4; i < 6; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 6; i < 8; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
		
		new Thread(() -> {
			for (int i = 8; i < 10; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
		
		new Thread(() -> {
			for (int i = 10; i < 12; i++) {
				String seed0 = seeds[i];
				DuplicateTableDAOImpl.errorRecord("start seed0 " + seed0, seed0);
				for (String seed1 : seeds)
					for (String seed2 : seeds)
						for (String seed3 : seeds) {
							DuplicateTableDAOImpl.errorRecord("start seed3 " + seed3, seed0 + " " + seed1 + " " + seed2 + " "
									+ seed3);
							for (String seed4 : seeds)
								for (String seed5 : seeds)
									for (String seed6 : seeds) {
										DuplicateTableDAOImpl.errorRecord("start seed6 " + seed6, seed0 + " " + seed1 + " " + seed2 + " "
												+ seed3 + " " + seed4 + " " + seed5 + " " + seed6);
										for (String seed7 : seeds)
											for (String seed8 : seeds)
												for (String seed9 : seeds) {
													DuplicateTableDAOImpl.errorRecord("start seed9 " + seed9, seed0 + " " + seed1 + " " + seed2 + " "
															+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
															+ " " + seed7 + " " + seed8 + " " + seed9);
													for (String seed10 : seeds)
														for (String seed11 : seeds) {
															AllInOne.testSeed(seed0 + " " + seed1 + " " + seed2 + " "
																	+ seed3 + " " + seed4 + " " + seed5 + " " + seed6
																	+ " " + seed7 + " " + seed8 + " " + seed9 + " "
																	+ seed10 + " " + seed11);
														}
												}
									}
						}
			}
		}).start();
		
	}
	
}
