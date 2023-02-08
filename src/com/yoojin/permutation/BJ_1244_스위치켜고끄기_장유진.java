package com.yoojin.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_장유진 {
	static int[] switchs;
	static int N;
	public static void main(String[] args) throws  IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		switchs = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0;i<N;i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		int studentsCnt = Integer.parseInt(in.readLine());
		
		for(int i = 0;i<studentsCnt;i++) {
			// 학생의 수 만큼 반복
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 남학생은 1 , 여학생은 2
			int location = Integer.parseInt(st.nextToken()); // 스위치 위치
			
			// 남학생인 경우
			if (gender == 1) {
				doMale(location);
			} else {
				// 여학생인 경우
				doFemale(location-1);
			}

			
		}
		
		for(int i = 0;i<N;i++) {
			if((i!=0) && i%20==0) {
				System.out.println();
			}
			System.out.print(switchs[i] + " ");
		}
		
		
	}
	private static void doMale(int location) {
		for(int i = 0;i<N;i++) {
			if ((i+1)%location == 0) {
				// location 의 배수이면
				switchs[i] = switchs[i] == 0?1:0; // 0이면 1, 1이면 0 담기
			}
		}
		
	}
	private static void doFemale(int location) {
		int d= 1;
		switchs[location] = switchs[location] == 0?1:0; // 위치 0과1 수정
		while(true) {
			if (location -d < 0 || location + d >= N) break; // 범위 벗어나는 경우 break
			if(switchs[location-d] != switchs[location+d]) break; // 양옆이 같지 않는 경우 break
			
			switchs[location-d] = switchs[location-d] == 0?1:0;
			switchs[location+d] = switchs[location+d] == 0?1:0;
			d++;
		}
	}
}
