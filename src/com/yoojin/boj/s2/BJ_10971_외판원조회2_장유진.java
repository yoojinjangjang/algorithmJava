package com.yoojin.boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10971_외판원조회2_장유진 {
	static int n;
	static boolean[] visited;
	static int[][] map;
	static long resultMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n];
		visited[0] = true;
		dfs(1,0,0);
		
		System.out.println(resultMin);
	}
	
	static void dfs(int cnt, int now, long cost) {
		if(cnt == n) {
			// 모두 방문함
			if(map[now][0] != 0) {
				resultMin = Math.min(resultMin, cost + map[now][0]);
			}
			return;
		}
		
		
		for(int i=1;i<n;i++) {
			if(!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(cnt+1, i,cost + map[now][i]);
				visited[i] = false;
			}
		}
	}
	
	

	
}

