package com.yoojin.bfsearch;

import java.util.ArrayList;

public class Combination {
	/*
	 * combination: 조합,
	 * N개의 수 중에서 순서가 없는 r개를 뽑음 
	 * (중복없음+)순서가 없으므로 1,2과 2,1은 같다. -> output배열없음
	 * 현재 선택한 원소보다 뒤에 있는 원소에 대해서만 탐색을 진행!  -> 반복문의 시작은 start 부터 (현재 탐색 위치 +1 값을 재귀호출)
	 */
	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth==r) {
			for(int i = 0;i<arr.length;i++) {
				if (visited[i]) {
					System.out.print(arr[i]+ " ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i = start;i<arr.length;i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	
	
	/*
	 * permutation: 순열
	 * n개 중 순서가 있는 r개를 뽑음
	 * 1,2과 2,1이 다르다. -> output 배열있음, 처음부터 마지막까지 반복하며 확인 수행 
	 */
	public static void permutation(int[] arr, int[] output, boolean[] visitied, int depth, int n, int r) {
		if (depth == r) {
			for(int i = 0;i<r;i++) {
				System.out.print(output[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(!visitied[i]) {
				visitied[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visitied, depth+1, n, r);
				visitied[i] = false;
			}
		}
	}
	
	
	/*
	 * 순열의 배열 구현
	 */
	static int n; // 기준 배열 길이
	static int[] arr = {1,2,3}; // 뽑을 배열
	static int num; // 뽑을 갯수
	public static void perm(ArrayList<Integer> list, int count) {
		if (count==0) {
			// 다 뽑았을 때
			System.out.println(list);
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(list.contains(arr[i])) {
				continue;
			}
			list.add(arr[i]);
			perm(list, count-1); // 뽑을 때마다 count-1
			list.remove(list.size()-1);//재귀 위해서 마지막에 넣은 원소 제거 
		}
	}
	
	/*
	 * 조합의 배열 구현
	 */
	public static void combi(ArrayList<Integer> list, int index, int count) {
		if(count==0) {
			System.out.println(list);
			return;
		}
		
		for(int i = index;i<n;i++) {
			list.add(arr[i]);
			combi(list, i+1, count-1); // 뽑을 때마다 count -1
			list.remove(list.size()-1); // 재귀위해 마지막 넣은 원소 제거 
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r = 2;
		combination(arr, new boolean[3], 0, 0, r);
		System.out.println();
		permutation(arr, new int[3], new boolean[3], 0, 3, r);
		System.out.println();
		combi(new ArrayList<Integer>(), 0,2);
	}
}
