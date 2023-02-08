package com.yoojin.recursive;


import java.util.Scanner;

public class BJ_11729_하노이탑_장유진 {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(1,3,N);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
	private static void hanoi(int from, int to, int n) {
		cnt++;
		if (n<=1) { // 한개의 원판만 남은 경우 목적지로 바로 이동
			sb.append(from + " "  + to+"\n");
			return;
		}
		
		int temp = 0;
		for(int i = 1;i<=3;i++) { // 목적지로 바로 이동하기 이전에 사용할 템프 변수 계산 
			if (i != from && i != to) temp = i;
		}
		
		hanoi(from,temp,n-1); // n-1개의 원판을 from에서 temp bar로 이동
		sb.append(from + " "  + to+"\n");
		hanoi(temp,to,n-1); // n-1개의 원판을 temp에서 to bar로 이동
	}
}