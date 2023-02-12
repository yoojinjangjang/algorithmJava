package com.yoojin.combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_저수지의_물의_총깊이_구하기_장유진 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("input (1).txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			int N = Integer.parseInt(in.readLine());
			char[][] rivers = new char[N][N];
			for(int i = 0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0;j<N;j++) {
					rivers[i][j] = st.nextToken().charAt(0);
				}
			}
			int MAX = Integer.MIN_VALUE;
			int[][] locs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if (rivers[i][j] != 'W') continue;
					int sum = 0;
					for(int[] loc : locs) {
						int nx = i + loc[0];
						int ny = j + loc[1];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (rivers[nx][ny] == 'W') {
							sum += 1;
						}
					}
					MAX = Math.max(MAX, sum);
				}
			}
			if (MAX == 0 ) System.out.printf("#%d %d%n", testNum,1);
			else System.out.printf("#%d %d%n", testNum,MAX);
		}
	}
}
