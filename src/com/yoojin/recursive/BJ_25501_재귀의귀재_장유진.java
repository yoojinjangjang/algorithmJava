package com.yoojin.recursive;

import java.util.Scanner;

public class BJ_25501_재귀의귀재_장유진 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testNum = 1;testNum <= T;testNum++) {
			cnt = 0;
			String s = sc.next();
			int isPali = isPalindrome(s);
			System.out.println(isPali + " " + cnt);
			
			
		}
		
	}
	
	private static int recursion(String str, int l, int r) {
		cnt++;
		if (l>=r) return 1;
		else if(str.charAt(l) != str.charAt(r)) return 0;
		else return recursion(str,l+1,r-1);
	}
	
	private static int isPalindrome(String str) {
		return recursion(str,0,str.length()-1);
	}
}
