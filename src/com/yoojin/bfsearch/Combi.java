package com.yoojin.bfsearch;

public class Combi {
	public static void combi(int[] arr, int[] output, int start, int depth, int r) {
		if (depth==r) {
			for(int i = 0;i<r;i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = start;i<arr.length;i++) {
			output[depth] = arr[i];
			combi(arr, output, i, depth+1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r = 2;
		combi(arr, new int[r], 0, 0, r);
	}
}
