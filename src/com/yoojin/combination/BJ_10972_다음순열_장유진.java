package com.yoojin.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10972_다음순열_장유진 {
	static int N;
	static boolean flag = false;
	static int[] finds;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		finds = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i =0;i<N;i++) {
			finds[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation()) {
			for(int i =0;i<N;i++) {
				System.out.print(finds[i]+ " ");
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}
		
		
	}
	
	private static boolean nextPermutation() {
		int i = N -1; // 뒤에서 부터 탐색하며
		while (i>0 && finds[i-1] >= finds[i]) {i--;} // 앞에값이 더 큰 경우 (내림차순인 곳) 끝까지 찾음
		if (i<=0) return false; // 가장 앞에까지 찾은 경우 (전부 내림차순 -> 마지막 요소임)
		
		int j = N -1; // 뒤에서부터
		while(finds[j] <= finds[i-1]) {j--;} // 해당 내림차순 값의 앞의 값보다 큰값을 찾을 때까지 반복
		
		int temp = finds[i-1];
		finds[i-1] = finds[j];
		finds[j] = temp; // i-1 부분과 j 부분을 바꿈 
		
		j = N -1; 
		while (i<j) { // 내림차순인 부분을 모두 오름차순으로 변경  -> 다음 순열
			temp = finds[i];
			finds[i] = finds[j];
			finds[j] = temp;
			i++; j--;
		}
		return true; // 모두 바뀐 경우 true 반환
	}
	

}
