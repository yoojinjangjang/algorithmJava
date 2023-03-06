package com.yoojin.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취_장유진 {
	static int N, M,C; 
	static int[][] maps;
	static int res;
	static int[][] profit;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("2116_벌꿀채취.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			maps = new int[N][N];
			profit = new int[N][N];
			for(int i=0;i<N;i++) {
				maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			res = 0;
			process();
			
			
			
			
			System.out.printf("#%d %d%n",testNum,res);
			
		}
	}
	
	static void process() {
		makeProfit();
		
		for(int i =0;i<N;i++) {
			for(int j= 0;j<N;j++) {
				combination(i,j+M,1,profit[i][j]);
			}
		}
	}
	
    private static void combination(int x, int y, int cnt, int sum) {
        
        if(cnt == 2) {
            res = Math.max(res, sum);
            return;
        }
        // 일꾼 B가 채취할 구간
        for (int i = x; i < N; i++) {
            for (int j = y; j <= N - M; j++) {
                combination(i, j, cnt + 1, sum + profit[i][j]);
            }
            y = 0;
        }
    }
    
    private static void makeProfit() {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                // 여기서 얻을 수 있는 최대 수익(부분집합)
                profitSubset(i, j, 0, 0, 0);
            }
        }
        
    }
    
    private static void profitSubset(int i, int j, int cnt, int sum, int totalSum) {
        
        if(sum > C) return;
        if(cnt == M) {
            // 해당 구간에서 최대 수익 갱신
            profit[i][j - M] = Math.max(profit[i][j - M], totalSum);
            return;
        }
        // 이 꿀을 채취해보자
        profitSubset(i, j + 1, cnt + 1, sum + maps[i][j], totalSum + maps[i][j] * maps[i][j]);
        // 이 꿀은 채취 안하고
        profitSubset(i, j + 1, cnt + 1, sum, totalSum);
        
    }

}
