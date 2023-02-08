package com.yoojin.bfsearch;

import java.util.Scanner;

public class BOJ_17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
	}
	
	void print(int N) {
		if(N==0) {
			System.out.println("라고 답변하였지.");
			return;
		}
		if(N==1) {
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		}
		
		System.out.println();
	}
}
