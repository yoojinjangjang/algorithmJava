package com.yoojin.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	 public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		for(int i = 0;i<N;i++) {
			house[i]  = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(house);
		
		int start = 1;
		int end = house[house.length-1] - house[0];
		int distance =0;
		int mid;
		int current;
		int count;
		while(start <= end) {
			mid = (start+end) /2;
			current = house[0];
			count = 1;
			
			for(int i = 1;i<N;i++) {
				if ((current+mid) <= house[i]) {
					current = house[i];
					count++;
				}
			}
			
			if(count >= C) {
				distance = mid;
				start = mid + 1;
			} else {
				end = mid -1;
			}
		}
		
		System.out.println(distance);
		
	}
}
