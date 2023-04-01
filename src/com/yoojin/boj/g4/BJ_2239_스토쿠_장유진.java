package com.yoojin.boj.g4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2239_스토쿠_장유진 {
	static int[][] sudoku;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		for(int i=0;i<9;i++) {
			sudoku[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		dfs(0);
		
		for(int i=0;i<9;i++) {
			for(int j =0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	private static void dfs(int cnt) {
		if(cnt == 81) {
			flag = true;
			return;
		}
		
		int x = cnt / 9;
		int y = cnt % 9;
		
		if(sudoku[x][y] != 0) {
			dfs(cnt+1); // 0이 아닌 경우 다음 값을 dfs 확인
		} else {
			
			// 0인 경우 1부터 9까지 확인하면서 가능한 경우 채우고 다음 dfs 호출하기
			for(int i=1;i<=9;i++) {
				if(!isValid(new Point(x,y),i)) continue; // 가능하지 않은 경우 다음값을 확인하기
				
				sudoku[x][y] = i;
				
				dfs(cnt+1);
				
				if(flag) return;
				sudoku[x][y] = 0;
			}
		}
		
	}

	private static boolean isValid(Point point, int num) {
		// 1. 가로 세로 확인
		for(int i=0;i<9;i++) {
			if (sudoku[point.x][i] == num || sudoku[i][point.y] == num) return false;
		}
		
		// 3방 탐색
		for(int i= (3*(point.x/3)); i <(3*(point.x/3)+3) ;i++) {
			for(int j= (3*(point.y/3)); j <(3*(point.y/3)+3) ;j++) {
				if(sudoku[i][j] == num) return false;
			}
		}
		
		
		return true;
	}
}
