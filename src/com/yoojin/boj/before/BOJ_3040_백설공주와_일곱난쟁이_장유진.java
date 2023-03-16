package com.yoojin.boj.before;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와_일곱난쟁이_장유진 {
	static int[] dwarfs = new int[9];
	static int[] pickDwarfs = new int[7];
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0;i<9;i++) {
			dwarfs[i] = Integer.parseInt(in.readLine());
		}
		
		combination(0,0);
	}
	
	public static void combination(int start, int depth) {
		if(depth==7) {
			// 합계 구하기 (100이라면 출력하고 시스템 종료)
			int sum = 0;
			for(int i = 0;i<9;i++) {
				if(visited[i]) {
					sum+= dwarfs[i];
				}
			}
			if (sum == 100) {
				for(int i = 0;i<9;i++) {
					if(visited[i]) {
						System.out.println(dwarfs[i]);
					}
				}
				System.exit(0);
			}
			return;
		}
		
		for(int i = start;i<9;i++) {
			if(visited[i]) continue;
			visited[i] =true;
			combination(i+1, depth+1);
			visited[i] = false;
		}
	}
}