package org.shil.omg.db;

public class ShardingUtil {
	
	public static int ShardingTotal = 8192;

	public static int getTableIndex(String seed){
		return Math.abs(seed.hashCode() % ShardingTotal);
	}
	
	public static void main(String[] args) {
		System.out.println(getTableIndex("I am a fucking good seed"));
	}
}
