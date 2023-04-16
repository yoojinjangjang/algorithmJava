package com.yoojin.boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BJ_1976, G4, 여행가자
 * 풀이 시작: 2시52분
 * 풀이 종료: 
 * 풀이 시간: 
 */
public class BJ_1976_여행가자_장유진 {
	static int[][] map;
	static int N,M;
	static int[] travels;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		travels = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			travels[i] = Integer.parseInt(st.nextToken()) -1;
		}
		
		for(int i = 0;i<M-1;i++) {
			visited = new boolean[N];
			if(!bfs(travels[i],travels[i+1])) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");

	}
	
	
	private static boolean bfs(int start,int end) {
		if(start==end) return true;
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty())
		{
			int cur = queue.poll();
			for(int i =0;i<N;i++) {
				if(map[cur][i] == 0) continue; // 연결되어있지 않음
				if(visited[i]) continue; // 이미 방문함
				if(i == end) return true;
				visited[i] = true;
				queue.offer(i);
			}
		}
		return false;
	}
}

/*

5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0 
1 1 0 0 0
1 0 0 0 0 
5 3 2 3 4

*/