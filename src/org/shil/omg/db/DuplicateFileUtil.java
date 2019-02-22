package org.shil.omg.db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DuplicateFileUtil {
	
	private static String lotteryFile = "D:/duplicate.txt";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
	
	public static void write2disk(String ... contents) {
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(lotteryFile,true));
			out.write(sdf.format(Calendar.getInstance().getTime()) + "\t");
			for(String c : contents) {
				out.write(c+"\t");
			}
			out.newLine();
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		write2disk("first","safsdf");
		write2disk("second");
	}
}
