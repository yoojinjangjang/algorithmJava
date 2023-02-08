package com.yoojin.bfsearch;

import java.beans.Visibility;

public class Study {
	
	/**순열*/
	public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int r) {
		if (depth==r) {
			for(int i = 0;i<r;i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = 0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visited, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	/**조합*/
	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth==r) {
			for (int i = 0;i<arr.length;i++) {
				if(visited[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		for(int i = start;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}

	/**중복순열*/
	public static void perm(int[] arr, int[] output, int depth, int r) {
		if (depth==r) {
			for(int i =0;i<r;i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = 0;i<arr.length;i++) {
			output[depth] = arr[i];
			perm(arr, output, depth+1, r);
		}
	}
	/**중복조합*/
	public static void combi(int[] arr, int[] output, int start, int depth, int r) {
		if (depth==r) {
			for(int i = 0;i<r;i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i =start;i<arr.length;i++) {
			output[depth] = arr[i];
			combi(arr, output, i, depth+1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r = 2;
		permutation(arr, new int[r], new boolean[arr.length], 0, r);
		System.out.println();
		perm(arr, new int[r], 0, r);
		System.out.println();
		combination(arr, new boolean[arr.length], 0, 0, r);
		System.out.println();
		combi(arr, new int[r], 0, 0, r);
	}
}
