package com.yoojin.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
	static int N, K;
	static ArrayList<Point> highPositions;
	static int[][] maps;
	static int maxHeight;
	static int result; 
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("swea_등산로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maps = new int[N][N];
			for(int i=0;i<N;i++) {
				maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			maxHeight = Integer.MIN_VALUE;
			// 1. 높은 봉우리 찾기 
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					maxHeight = Math.max(maxHeight, maps[i][j]);
				}
			}
			
			highPositions = new ArrayList<Point>();
			
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {

					if(maps[i][j] == maxHeight) {
						highPositions.add(new Point(i,j));
					}
				}
			}
			
			result = Integer.MIN_VALUE;
			// 2. 하나씩 k만큼 줄인후 dfs 수행
			for(int i = 0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k = 1;k<=K;k++) {
						
						maps[i][j] -= k;
						// maps의 가장 높은 곳 돌기
						for(int n = 0;n<highPositions.size();n++) {
							Point start = highPositions.get(n);
							if(maps[start.x][start.y] == maxHeight) {
								dfs(start, 1);
							}
						}
						maps[i][j] += k;
					}
				}
			}
			
			System.out.printf("#%d %d%n", testNum, result);
		}
	}
	static int[][] locs = {{-1,0},{1,0},{0,1},{0,-1}};
	private static void dfs(Point start, int dist) {
		for(int[] loc:locs) {
			int nx = start.x + loc[0];
			int ny = start.y + loc[1];
			if(nx < 0||nx>=N||ny <0||ny>=N) continue;
			if(maps[nx][ny] < maps[start.x][start.y]) { 
				dfs(new Point(nx,ny), dist+1);
			}
		}
		
		result = Math.max(result, dist);
	}
}
