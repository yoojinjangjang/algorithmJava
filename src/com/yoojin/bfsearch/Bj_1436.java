package com.yoojin.bfsearch;

import java.util.Scanner;

public class Bj_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 0;
		while(N > 0) {
			num += 1;
			if (String.valueOf(num).contains("666")) {
				N -= 1;
			}
		}
		System.out.println(num);
	}
}
