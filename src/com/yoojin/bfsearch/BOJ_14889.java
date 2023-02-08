package com.yoojin.bfsearch;

import java.util.Scanner;

public class BOJ_14889 {
	static int N;
	static int[][] capacity;
	static boolean[] visited;
	
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N];
		
		for (int i = 0;i<N;i++) {
			for (int j = 0;j<N;j++) {
				capacity[i][j] = sc.nextInt();
			}
		}
		
		
		
		
	}
	
	static void combi(int idx, int count) {
		if (count == N /2) {
			// 계산
			return;
		}
		
		for(int i = idx;i<N;i++) {
			if (!visited[i]) {
				visited[i] = true;
				combi(i+1,count+1);
				visited[i] = false;
			}
		}
	}
	
	static void getMin() {
		int startTeam = 0;
		int linkTeam = 0;
		
		for(int i = 0;i<N-1;i++) {
			for (int j = i+1;j<N;j++) {
				if (visited[i] == true && visited[j] == true) {
					startTeam += capacity[i][j];
					startTeam += capacity[j][i];
				} else if (visited[i] == false && visited[j] == false) {
					linkTeam += capacity[i][j];
					linkTeam += capacity[j][i];
				}
			}
		}
		
		int val = Math.abs(startTeam-linkTeam);
		
		if(val==0) {
			System.out.println(val);
			System.exit(0);
		}
		
		MIN = Math.min(MIN, val);
	}
}
