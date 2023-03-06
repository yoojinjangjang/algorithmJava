package com.yoojin.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_보호필름 {
	static int[][] films;
	static int[][] tempFilms;
	static int D,W,K;
	static int currentTest;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("swea_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			currentTest = testNum;
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			films = new int[D][W];
			for(int i =0;i<D;i++) {
				films[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			result = Integer.MAX_VALUE;
			for(int medicine = 0;medicine <= D;medicine++) {
				if(combination(new int[medicine], 0, 0, medicine)) {
					break;
				}
			}
		}
	}
	
	private static boolean combination(int[] output, int cnt, int start, int medicine) {
		if(cnt == medicine) {
			// 투입횟수만큼 조합을 뽑음
			// a와 b로 나누기 
			if(divideAandB(output,0,medicine,new boolean[medicine])) {
				return true;
			}
			return false;
		}
		
		for(int i=start;i<D;i++) {
			output[cnt] = i;
			if(combination(output, cnt+1, i+1, medicine)) {
				return true;
			}
		}
		return false;
	}
	static int result;
	private static boolean divideAandB(int[] output, int cnt, int medicine, boolean[] isA) {
		if(medicine >= result) {
			return true;
		}
		if(cnt == medicine) {
			tempFilms = new int[D][W];
			for(int i = 0;i<D;i++) {
				tempFilms[i] = Arrays.copyOf(films[i], W); // temp 배열 복사
			}
			
			for(int i=0;i<medicine;i++) {
				if(isA[i]) {
					// A임
					for(int j = 0;j<W;j++) {
						tempFilms[output[i]][j] = 0;
					}
				} else {
					for(int j =0;j<W;j++) {
						tempFilms[output[i]][j] = 1;
					}
				}
			}
			
			// 성능검사
			if(check()) {
				result = Math.min(result, medicine);
				System.out.printf("#%d %d%n",currentTest,medicine);
				return true;
			}
			return false;
		}
		
		isA[cnt] = true;
		if(divideAandB(output, cnt+1, medicine, isA)) {
			return true;
		}
		isA[cnt] = false;
		if(divideAandB(output, cnt+1, medicine, isA)) {
			return true;
		}
		
		return false;
	}

	private static boolean check() {
		for(int j =0;j<W;j++) {
			int cnt = 1;
			boolean isCan = false;
			for(int i =0;i<D-1;i++) {
				if(tempFilms[i][j] != tempFilms[i+1][j]) {
					cnt = 1;
					continue;
				}
				if(++cnt >= K) {
					isCan = true;
					break;
				}
			}
			if(isCan == false) return false;
		}
		
		return true;
	}
}
