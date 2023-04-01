package com.yoojin.boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1149_RGB거리 {
	static int[][] dp;
	static int N;
	static int[][] cost;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		for(int i =0;i<N;i++) {
			cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0] = cost[0];
		
		for(int i =0;i<N-1;i++) {
			for(int j = 0;j<3;j++) {
				for(int r = 0;r<3;r++) {
					if(j != r) {
						dp[i+1][r] = Math.min(dp[i+1][r], dp[i][j] + cost[i+1][r]);
					}
				}
			}
		}
		
	
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}
	
}