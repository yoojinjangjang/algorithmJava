package com.yoojin.recursive;

import java.util.Scanner;

public class BJ_2447_별찍기_장유진 {
	static char[][] stars;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		stars = new char[N][N];
		printStart(N,0,0);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if (stars[i][j] == 0 ) {
					sb.append(' ');
					continue;
				}
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void printStart(int n,int c,int r) {

		if(n==1) {
			stars[c][r] = '*';
			return;
		}
		
		int cnt = 0;
		for(int i = 0;i<n;i+= (n/3)) {
			for(int j = 0;j<n;j+= (n/3)) {
				cnt++;
				if(cnt == 5) {
					cnt++;
					continue;
				}
				printStart(n/3,c+i,r+j);
			}
		}
		
		
	}
	
	
}
