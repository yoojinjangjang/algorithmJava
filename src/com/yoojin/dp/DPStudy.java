package com.yoojin.dp;

public class DPStudy {
	// DP를 사용 시 작은 문제의 결과값을 ㅓ장하는 배열
	// TOP-down, Bottom-Up 별개 생성
	static int[] topDown_memo;
	static int[] bottomup_table;
	
	public static void main(String[] args) {
		int n = 30;
		topDown_memo = new int[n+1];
		bottomup_table = new int[n+1];
		
		
        long startTime = System.currentTimeMillis();
        System.out.println(topDown(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Top-Down DP 소요 시간 : " + (endTime - startTime));
        
        System.out.println();
        
        startTime = System.currentTimeMillis();
        System.out.println(bottomUp(n));
        endTime = System.currentTimeMillis();
        System.out.println("Bottom-Up DP 소요 시간 : " + (endTime - startTime));
		
	}
	
	// DP Top Down을 사용해 Fibonacci 계산
	public static int topDown(int n) {
		// 기저 상태에 도달 시 0,1로 초기화
		if(n<2) return topDown_memo[n] = n;
		
		// 메모에 계산된 값이 있으면 바로 반환
		if(topDown_memo[n] >0) return topDown_memo[n];
		
		// 재귀 사용
		topDown_memo[n] = topDown(n-1) + topDown(n-2);
		
		return topDown_memo[n];
	}
	
	// DP Bottom up을 사용해 피보나치 계산
	public static int bottomUp(int n) {
		// 기저 상태의 경우 사전에 미리 저장
		bottomup_table[0] = 0; bottomup_table[1] = 1;
		
		//반복문 사용
		for(int i = 2;i<=n;i++) {
			// Table 채움
			bottomup_table[i] = bottomup_table[i-1] + bottomup_table[i-2];
		}
		return bottomup_table[n];
	}
}
