package com.yoojin.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2023_신기한_소수_장유진 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		int[] first_num = {2,3,5,7};
		for(int i : first_num) {
			getNext(i, 0);
		}
		
		
	}
	private static void getNext(int before, int cnt) {
		if(cnt == N-1) {
			System.out.println(before);
			return;
		}
		
		for(int i = 1;i<10;i+=2) {
			if(isPrime(10*before+i)) {
				getNext(10*before+i,cnt+1);
			}
		}
		
	}
	private static boolean isPrime(int n) {
		for(int i = 2;i<=Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}