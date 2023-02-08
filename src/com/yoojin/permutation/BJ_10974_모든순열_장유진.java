package com.yoojin.permutation;


import java.util.Scanner;

public class BJ_10974_모든순열_장유진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 1;i<=N;i++) { 
			arr[i-1] = i;
		}
		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		
		perm(arr, output, visited, 0, N, N);
		
	}
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) { // 순열 사이즈 만큼 찾은 경우 
			print(output, r); // 프린트 
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if (visited[i] != true) { // 방문하지 않은 경우
				visited[i] = true; // 방문 처리
				output[depth] = arr[i]; // 출력배열에 저장
				perm(arr, output, visited, depth + 1, n, r); // 재귀 호출 수행
				visited[i] = false; // 비방문 처리 
			}
		}
	}
	
	static void print(int[] arr, int r) { // 순열 출력 함수 
		for (int i = 0;i<r;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}