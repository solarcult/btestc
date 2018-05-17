package org.shil.omg;

import java.util.Scanner;

public class X {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("what is your name?");
		
		String name = in.nextLine();
		
		System.out.println("Hello: "+name);
		
		System.out.println("a:");
		
		int a = in.nextInt();
		
		System.out.println("b:");
		
		int b = in.nextInt();
		
		System.out.println("c:");
		
		int c = in.nextInt();  
		
		System.out.println(a+" + "+b+" = "+ (a+b-c));
	}

}
