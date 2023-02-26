package com.yoojin.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_장유진 {

	static int R,C; 
	static char[][] maps;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maps = new char[R][C];
		for(int i =0;i<R;i++) {
			String str = in.readLine();
			for(int j =0;j<C;j++) {
				maps[i][j] = str.charAt(j);
			}
		}
		
		boolean[] alphabets =new boolean[26];
		alphabets[(int)(maps[0][0] - 65)] = true;
		
		dfs(0,0,alphabets,1);
		System.out.println(MAX);
		
	}
	static int MAX = Integer.MIN_VALUE;
	static int[][] locs = {{1,0},{-1,0},{0,1},{0,-1}};

	
	static void dfs(int x,int y,boolean[] alphabets, int dist) {
		// 현재 distance 의 최대값 갱신
		MAX = Math.max(MAX, dist);
		
		// 출발점의 사방을 탐색하며
		for(int[] loc:locs) {
			int nx = x + loc[0];
			int ny = y + loc[1];
			if(nx<0||nx>=R||ny<0||ny>=C) continue;
			if(alphabets[(int)(maps[nx][ny]-65)]) continue;
			boolean[] newAlpha = Arrays.copyOf(alphabets, 26);
			newAlpha[(int)(maps[nx][ny]-65)] = true;
			dfs(nx,ny,newAlpha,dist+1);
		}
		
		// 범위 검사
		// 해당 알파벳이 alphabets에서 true인지 확인
		// 이미 있는 것이 아니라면 -> false이면 
		// - dfs를 재귀호출 
		
	}
}
