package com.yoojin.twopointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11728 {
	static int N;
	static int M;
	static int[] newArr;
	static int[] aArr;
	static int[] bArr;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		aArr = new int[N];
		bArr = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i = 0;i<N;i++) {
			aArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0;i<M;i++) {
			bArr[i] = Integer.parseInt(st.nextToken());
		}
		
		newArr = new int[N+M];
		doPlusAandB();
		for(int n:newArr) {
			out.write(n+" ");
		}
		out.flush();
		out.close();
				
	}
	private static void doPlusAandB() {
		int a = 0;
		int b = 0; // 초기값 설정
		int n = 0; // a- a배열의 인덱스, b-b배열의 인덱스, n-new배열의 인덱스
		while(a<N && b <M) {
			// a 인덱스와 b 인덱스가 범위 안인 경우 
			if(aArr[a] <= bArr[b]) {
				// aArr의 현재 값이 더 작은 경우 해당 값을 새 배열에 추가한다. 
				newArr[n] = aArr[a];
				n++; a++; // 각 인덱스를 증가시킨다.
			} else {
				// bArr의 현재 값이 더 작은 경우 해당 값을 새 배열에 추가한다. 
				newArr[n] = bArr[b];
				n++; b++;
			}
		}
		
		// 두 배열 모두 추가가 되지 않은 경우 나머지 요소들을 추가해준다. 
		if (a < N) {
			for(int i = a;i<N;i++) {
				newArr[n] = aArr[i];
				n++;
			}
		} else {
			for(int i = b;i<M;i++) {
				newArr[n] = bArr[i];
				n++;
			}
		}
	}
}
