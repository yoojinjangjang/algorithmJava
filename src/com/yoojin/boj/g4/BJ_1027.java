package com.yoojin.boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 고층 빌딩 : g4
 * 풀이시작: 8:28
 * 풀이시간: 
 */
public class BJ_1027 {
	static int N;
	static int[] arr;
	static int[] cnt;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		cnt = new int[N];
		
		getBuildingsCnt();
		Arrays.sort(cnt);
		
		System.out.println(cnt[N-1]);
		
	}

	private static void getBuildingsCnt() {
		for(int i =0;i<N-1;i++) {
			cnt[i] += 1;
			cnt[i+1] += 1;
			double slope = arr[i+1]-arr[i];
			for(int j = i+1;j<N;j++) {
				double nextSlope = (double)(arr[j]-arr[i])/(j-i);
				if(nextSlope <= slope) continue;
				slope = nextSlope;
				cnt[i]++;
				cnt[j]++;
			}
		}
		
		
	}
}
