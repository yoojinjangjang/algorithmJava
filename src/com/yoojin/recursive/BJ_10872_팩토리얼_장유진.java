package com.yoojin.recursive;

import java.util.Scanner;

public class BJ_10872_팩토리얼_장유진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));
	}

	private static int factorial(int n) {
		if (n==0) return 1;
		if(n<2) return n;
		
		return factorial(n-1) * n;
	}
}
