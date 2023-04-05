package com.yoojin.boj.g4;
/*
 * 백준 1253 좋다 
 * 
 * 풀이시간: 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BJ_1253 {
	static int N;
	static long[] arr;
	static boolean[] checkTrue;
	static HashSet<Long> set = new HashSet<>();
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		checkTrue = new boolean[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(arr);
		for(int i = 0;i<N;i++) {
			if(check(i)) {
				set.add(arr[i]);
			}
		}
		
		
		for(int i=0;i<N;i++) {
			if(set.contains(arr[i])) {
				cnt++;
			}
		}
		if(N <= 2) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
			
		}
		
		
	}
	
	private static boolean check(int idx) {
		int start = 0;
		int end = N-1;
		if(start == idx) start++;
		if (end == idx) end--;
		long key = arr[idx];
		while(start < end) {

			long value = arr[start] + arr[end];
			if(value == key) return true;
			
			if(value < key) {
				start++;
			} else {
				end--;
			}
			if(start == idx) start++;
			if (end == idx) end--;
		}
		return false;
	}
}
