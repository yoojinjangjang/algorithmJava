package com.yoojin.permutation;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_10974_2 {
	static int N;
	static int[] output;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		output = new int[N];
		visited = new boolean[N];
		
		permutation(0);
	}
	
	
	public static void permutation(int depth) {
		if(depth==N) {
			for(int i = 0;i<N;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
		}
		
		for(int i =0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = i+1;
			permutation(depth+1);
			visited[i] = false;
		}
	}
}
