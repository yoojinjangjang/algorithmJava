package com.yoojin.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] sources = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0;i<N;i++) {
			sources[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		int j = N-1;
		int sum;
		int tmp;
		int MIN = Integer.MAX_VALUE;
		int sol[] = new int[N];
		Arrays.sort(sources); // 정렬 먼저
		while(i<j) { // 양끝부터 확인하면서 
			sum = sources[i] + sources[j]; // 두 용액의 합을 구하고
			tmp = Math.min(MIN, Math.abs(sum)); // 모든 용액의 합중 가장 작은 값을 찾아야 하므로 MIN을 구하고 (현재 합과 기존의 합)
			
			if (tmp < MIN) { // 기존의 합보다 작은 경우
				sol[0] = i;	// 현재 용액들의 위치를 저장
				sol[1] = j;
				MIN = tmp; // MIN을 갱신
			}
			if (sum > 0) j--; // 합계가 0보다 큰경우에는 오른쪽을 줄이고
			else i++; // 아닌 경우 왼쪽을 줄임 ! 
		}
		
		System.out.println(sources[sol[0]] + " " + sources[sol[1]]); // 출력 !
		
		
	}
	

}	

