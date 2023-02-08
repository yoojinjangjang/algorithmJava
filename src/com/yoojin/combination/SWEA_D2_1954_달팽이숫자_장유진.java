package com.yoojin.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D2_1954_달팽이숫자_장유진 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			int N = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[N][N]; // 달팽이가 회전할 배열
			for(int i = 0;i<N;i++) {  // 첫번째 줄을 채워주기 (1,2,3, ..N)
				arr[0][i] = i+1;
			}
			
			int x = 0; // 달팽이의 회전 인덱스
			int y = N-1; // 달팽이의 회전 인덱스 (y) -> N-1: 시작할 위치이므로 제일 위의 줄의 가장 오른쪽
			
			int cur = N; // 달팽이가 남길 흔적 값 (현재값)
			
			int[][] locs = {{1,0},{0,-1},{-1,0},{0,1}}; // 위치 배열 (각 요소를 돌면서 증가시켜줄 예정)
			int loc = 0; // locs 배열의 인덱스 (0~3)을 반복
			
			for(int repeat = N-1;repeat >= 1; repeat--) {
				// 반복할 횟수
				for(int i = 0;i<2;i++) {
					// 각각을 2번씩 반복하며

					
					for (int j = 0;j<repeat;j++) {
						x += locs[loc][0];
						y += locs[loc][1];
						// 반복 횟수만큼 돌며
						cur += 1; // 현재 값을 증가시키고 
						arr[x][y] = cur; // 해당 값을 배열에 저장한다. 

					}
					// 반복이 종료된 경우 다음 반복을 위해 위치값을 변경한다. 
					loc = (loc+1)%4;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.printf("#%d%n",testNum);
			System.out.print(sb.toString());
		}
	}
}
