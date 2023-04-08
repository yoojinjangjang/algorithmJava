package com.yoojin.combination;

import java.util.Arrays;
import java.util.Scanner;


public class Combination {
	static int[] arr;
	static boolean[] visited;
	static int[] output;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		output = new int[M];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		permutation(0);
		
		System.out.println();
		
		combination(0,0);
		
		System.out.println();
		
		perm(0);
		
		System.out.println();
		
		comb(0,0);
	}
	
	
	private static void permutation(int cnt) { // 순서가 있는 열
		if(cnt==M) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[cnt] = arr[i];
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	private static void combination(int cnt, int start) {
		// 순서가 없는 조합
		if(cnt == M) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i = start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[cnt] = arr[i];
			combination(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	private static void perm(int cnt) {
		if(cnt == M) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i =0;i<N;i++) {
			output[cnt] = arr[i];
			perm(cnt+1);
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt==M) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i =start;i<N;i++) {
			output[cnt] = arr[i];
			comb(cnt+1,i);
		}
	}
}
