package com.yoojin.bfsearch;

public class Perm {
	public static void perm(int[] arr, int[] output, int depth, int r) {
		if (depth==r) {
			for(int i = 0;i<r;i++) {
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
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r = 2;
		perm(arr, new int[r], 0, r);
	}
	
}
