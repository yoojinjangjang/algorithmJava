package com.yoojin.combination;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_요리사_장유진 {
	static int[][] foods;
	static int min = Integer.MAX_VALUE;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int testNum = 1;testNum<=T;testNum++) {
			N = Integer.parseInt(in.readLine());
			foods = new int[N][N];
			for(int i = 0;i<N;i++) { // food 배열 입력받기
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0;j<N;j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			// 순열을 구하고 해당 순열의 값들을 회전하며 foods[x][y] + food[y][x] 를 전부 더해준다. 
			combination(0,0,N/2);
			// 그 중 최솟값을 구하고 최솟값을 출력해준다. 
			
			System.out.printf("#%d %d%n",testNum,min);
			
			
			
		}
	}
	private static void combination(int start, int depth, int r) {
		if(depth == r) {
			getMin();
			return;
		}
		
		for(int i = start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combination(i+1,depth+1, r);
			visited[i] = false;
			

		}
	}
	
	
	private static void getMin() {
		int sumA = 0;
		int sumB = 0;
		
		for(int i = 0;i<N-1;i++) {
			for(int j = i+1;j<N;j++) {
				if (visited[i] == true && visited[j] == true) { // 둘다 true이면 afood 
					// A food 
					sumA += foods[i][j] + foods[j][i];
				} else if (visited[i] == false && visited[j] == false) {
					// 둘다 false이면 bfood
					sumB += foods[i][j] + foods[j][i];
				}
			}
		}
		
		min = Math.min(Math.abs(sumA-sumB), min);
	}
}