package com.yoojin.shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
	public static final int INF = (int) 1e9;
	public static int n,m; // n노드, m간선
	public static int[][] graph = new int[501][501];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 그래프 초기화
		for(int i = 0;i<501;i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기자신 0으로 초기화
		for(int i = 1;i<=n;i++) {
			graph[i][i] = 0;
		}
		
		// 각 간선 정보 입력
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph[a][b] = c;
		}
		
		// 플로이드 수행
		for(int k = 1;k<=n;k++) {
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=n;j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		// 출력
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				if(graph[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.println(d[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
}
