package com.yoojin.combination;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치_장유진 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] mogis = new int[N][N];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					mogis[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i =0;i<=N-M;i++) {
				for(int j = 0;j<=N-M;j++) {
					int sum = 0;
					for(int x = i;x<i+M;x++) {
						for(int y = j;y<j+M;y++) {
							sum += mogis[x][y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + testNum+ " "+max);
		}
	}
}
