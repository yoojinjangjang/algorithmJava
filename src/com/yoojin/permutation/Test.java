package com.yoojin.permutation;

import java.util.Scanner;

public class Test {
	static int[] input;
	static boolean[] visited;
	static int[] output;
	static int N,R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		for(int i =1;i<=N;i++) {
			input[i-1] = i;
		}
		
		visited = new boolean[N];
		output = new int[R];
		permutation(0);
		
		visited = new boolean[N];
		output = new int[R];
		combination(0, 0);
		
		visited = new boolean[N];
		subset(0);
		
		output = new int[R];
		perm(0);

		output = new int[R];
		combi(0,0);
		

	}
	
	public static void permutation(int cnt) {
		if(cnt == R) {
			for(int i =0;i<R;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[cnt] = input[i];
			permutation(cnt+1);
			visited[i] = false;
		}
		
	}
	
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			for(int i =0;i<R;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =start;i<N;i++) {
			output[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			for(int i =0;i<N;i++) {
				if(visited[i]) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}
	
	public static void perm(int cnt) {
		if (cnt == R) {
			for(int i=0;i<R;i++) {
				System.out.print(output[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0;i<N;i++) {
			output[cnt] = input[i];
			perm(cnt+1);
		}
	}
	
	public static void combi(int cnt, int start) {
		if(cnt==R) {
			for(int i =0;i<R;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =start;i<N;i++) {
			output[cnt] = input[i];
			combi(cnt+1,i);
		}
	}
	
}
