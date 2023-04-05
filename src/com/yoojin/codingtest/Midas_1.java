package com.yoojin.codingtest;

import java.util.ArrayList;
import java.util.Collections;

public class Midas_1 {
	static boolean[] rotate;
	static int[] A;
	static int[] B;
	static int N;
    static long result = Long.MIN_VALUE;

    public static long solution(int n, int[] a, int[] b) {
        long answer = 0;
        N = n;
        rotate = new boolean[n];
        A = a;
        B = b;
        
        
        
        subset(0);
        answer = result;
        return answer;
    }
    
    static void subset(int cnt) {
    	if(cnt == N) {
    		ArrayList<Square> squares = new ArrayList<>();

    		for(int i=0;i<N;i++) {
                if(rotate[i]) {
                    // 회전함 
                    squares.add(new Square(B[i],A[i]));
                } else {
                	squares.add(new Square(A[i],B[i]));
                }
    		}
    		// 넓이를 계산
            Collections.sort(squares);
            

            // 하나씩 넓이 계산
            int h = squares.get(0).height;
            int w = squares.get(0).width;
            result = Math.max(result, h*w);
            for(int i =1;i<N;i++) {
                h = squares.get(i).height;
                w += squares.get(i).width;
                result = Math.max(result, h*w);
            }
            
    		return;
    	}
    	
    	// 1. 첫번째 회전 
    	rotate[cnt] = true;
    	subset(cnt+1);
    	
    	rotate[cnt] = false;
    	subset(cnt+1);
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(4, new int[] {3,2,4,2}, new int[] {3,1,7,5}));
//    	System.out.println(solution(2, new int[] {3,4}, new int[] {4,5}));
	}
    
    static class Square implements Comparable<Square>{
    	int height;
    	int width;
		@Override
		public String toString() {
			return "square [height=" + height + ", width=" + width + "]";
		}
		public Square(int height, int width) {
			super();
			this.height = height;
			this.width = width;
		}
		@Override
		public int compareTo(Square o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.height, this.height);
		} 
    	
    	
    }
}
