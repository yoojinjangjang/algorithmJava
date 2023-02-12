package com.yoojin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arrA1 = new int[N]; // 첫번쨰 스위치를 켜놓을 배열 (cnt++)
		int[] arrA2 = new int[N]; // 첫번째 스위치를 꺼놓을 배열
		int[] arrB = new int[N];
		
		int cnt1 = 1; // 첫번째 스위치 켜놓을 배열의 스위치 작동 수 이므로 1부터 시작
		int cnt2 = 0; // 켜놓지 않았으므로 0부터 시작
		
		String str = in.readLine();
		for(int i = 0;i<N;i++) {
			arrA1[i] = str.charAt(i) - '0';
			arrA2[i] = arrA1[i];
		}
		
		str = in.readLine();
		for(int i =0;i<N;i++) {
			arrB[i] = str.charAt(i) -'0';
		}
		
		arrA1[0] = 1 - arrA1[0];
		arrA1[1] = 1 - arrA1[1]; // 1인 경우 0, 0인 경우 1로 바뀜
		
		for(int i = 1;i<N;i++) {
			if(arrA1[i-1] != arrB[i-1]) {
				arrA1[i-1] = 1 - arrA1[i-1];
				arrA1[i] = 1 - arrA1[i];
				if(i<N-1) {
					arrA1[i+1] = 1 - arrA1[i+1];
				}
				cnt1++;
			}
		}
		
		for(int i = 1;i<N;i++) {
			if(arrA2[i-1] != arrB[i-1]) {
				arrA2[i-1] = 1 - arrA2[i-1];
				arrA2[i] = 1 - arrA2[i];
				if(i<N-1) {
					arrA2[i+1] = 1 - arrA2[i+1];
				}
				cnt2++;
			}
		}
		
		if(arrA1[N-1] != arrB[N-1]) cnt1 = Integer.MAX_VALUE;
		if(arrA2[N-1] != arrB[N-1]) cnt2 = Integer.MAX_VALUE;
		
		
		if(arrA1[N-1] != arrB[N-1] && arrA2[N-1] != arrB[N-1]) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(cnt1, cnt2));
		}
	}
}
