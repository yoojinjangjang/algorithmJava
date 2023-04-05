package com.yoojin.codingtest;


import java.util.ArrayList;
import java.util.Collections;

public class Midas_2 {
	static boolean[] isG1OrG2;
	static ArrayList<Integer> g1 = new ArrayList<>();
	static ArrayList<Integer> g2 = new ArrayList<>();
	static int[] B;
	static int N;
	static double C,D;
	static long result = Long.MIN_VALUE;
    public static long solution(int n, int c, int d, String[] a, int[] b) {
        long answer = 0;
        B = b;
        N = n;
        C = (double)c/100;
        D = (double)d/100;
        isG1OrG2 = new boolean[n];
        
        subset(0);
        
        return result;
    }
    
    private static void subset(int cnt) {
    	if(cnt == N) {
    		// 각 그룹에 대하여 계산
    		g1 = new ArrayList<>();
    		g2 = new ArrayList<>();
    		for(int i=0;i<N;i++) {
    			if(isG1OrG2[i]) {
    				g1.add(B[i]);
    			} else {
    				g2.add(B[i]);
    			}
    		}
    		
    		// g1의 세금 계산
    		int g1Total = g1Calc();
    		int g2Total = g2Calc();
    		int max = Math.max(g1Total, g2Total);
    		result = Math.max(max, result);
    		return;
    	}
    	
    	
    	isG1OrG2[cnt] = true;
    	subset(cnt+1);
    	
    	isG1OrG2[cnt] = false;
    	subset(cnt+1);
    }

	private static int g2Calc() {
		if(g2.isEmpty()) return 0;
		int g2Total =  Collections.max(g2); // 최대값 찾기 
		
		double tax = D * (double)(g2Total*g2Total);
		double sum = 0;
		for(int i=0;i<g2.size();i++) {
			sum += g2.get(i);
		}
		
		return (int)((sum - tax) * 100);
	}

	private static int g1Calc() {
		if(g1.isEmpty()) return 0;
		double sum = 0;
		for(int i=0;i<g1.size();i++) {
			sum += (g1.get(i) - (double)(g1.get(i) * C));
		}
		
		return (int)(sum * 100);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(2, 100, 10, new String[] {"fan","Fan"},new int[] {1,2}));
	}
}