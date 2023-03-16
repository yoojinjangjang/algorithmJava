package com.yoojin.boj.before;

import java.util.Scanner;

public class BOJ_2563_색종이_장유진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] colorPapers = new int[n][2]; 
		for (int index = 0;index < n;index++) {
			colorPapers[index][0] = sc.nextInt();
			colorPapers[index][1] = sc.nextInt();
		}
		
		int[][] amount = new int[100][100];
		int result = 0;
		for (int colorN = 0;colorN < n; colorN++ ) {
			// 각 색종이 별로
			for (int i = 0;i<10;i++) {
				for (int j =0;j<10;j++) {
					if (amount[colorPapers[colorN][0]+i][colorPapers[colorN][1]+j] != 1) {
						amount[colorPapers[colorN][0]+i][colorPapers[colorN][1]+j] = 1;
						result += 1;
					}
				}
			}
		}
		System.out.println(result);

	}

}