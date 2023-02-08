package com.yoojin.bfsearch;
/*
 * 순열: 서로 다른 n개에서 r개를 뽑아서 정렬 하는 경우의 수
 */
public class Permutation {
	public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth==r) {
			for(int i = 0;i<r;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visited, depth+1, n, r);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r = 2;
		permutation(arr, new int[3], new boolean[3], 0, 3, r);
	}

}
