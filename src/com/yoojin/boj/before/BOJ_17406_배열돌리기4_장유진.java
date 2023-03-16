package com.yoojin.boj.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4_장유진 {
	public static int n; // n행
	public static int m; // m행
	public static int k; // k개의 회전 수행
	public static int[][] arr;
	public static int[][] temp;
	public static int[][] output;
	public static int[] permsOut;
	public static int[][] locs = {{0,1},{1,0},{0,-1},{-1,0}}; // 우하좌상
	public static int[][] rotations;
	public static boolean[] visited;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m]; // arr 배열
		
		for(int i =0;i<n;i++) {
			arr[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		rotations = new int[k][3];
		
		for(int i =0;i<k;i++) {
			// k개의 회전 받기
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()); // 행 
			int c = Integer.parseInt(st.nextToken()); // 열
			int s = Integer.parseInt(st.nextToken()); // plus,minus
			rotations[i][0] = r;
			rotations[i][1] = c;
			rotations[i][2] = s;
		}
		
		// 순열을 수행 
		permsOut = new int[k];
		visited = new boolean[k];
		output = new int[n][m];
		temp = new int[n][m];
		permutation(0);
		System.out.println(min);
	}
	
	public static void permutation(int depth) {
		if (depth==k) { // k 개 인 경우
			// 한 순열을 수행시마다 arr 배열을 복사한 temp 배열이 필요하다 
			for(int i =0;i<n;i++) { // 2차원 배열 dirty copy
				System.arraycopy(arr[i], 0, temp[i], 0, m);
			}
			
			// permsOut 배열에서 하나씩 꺼내면서 해당 배열 돌리기를 수행한다. 
			for(int i =0;i<k;i++) {
				// output 배열의 초기화 
				output = new int[n][m];
				for(int k =0;k<n;k++) { // 2차원 배열 dirty copy
					System.arraycopy(temp[k], 0, output[k], 0, m);
				}
				// 한개씩 꺼내면서 반복을 돌리 것 
				int startX = rotations[permsOut[i]][0] - rotations[permsOut[i]][2] -1;
				int startY = rotations[permsOut[i]][1] - rotations[permsOut[i]][2]-1; 
				int endX = rotations[permsOut[i]][0] + rotations[permsOut[i]][2]-1;
				int endY = rotations[permsOut[i]][1] + rotations[permsOut[i]][2]-1;
				int R = endX - startX +1;
				int C = endY - startY +1;
				int order = R > C? C/2:R/2;
				for(int j = 0;j<order;j++) {
					rotate(startX+j, startY+j, endX-j, endY-j);
				}
				temp = output;
			}
			
			for(int k = 0;k<n;k++) {
				int sum = 0;
				for(int j = 0;j<m;j++) {
					sum += temp[k][j];
				}
				min = Math.min(min, sum);
			}
			
			// 반복 다돌았으면 조합의 행 합을 구함
			return;
		}
		
		for(int i =0;i<k;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permsOut[depth] = i;
			permutation(depth+1);
			visited[i] = false;
			
		}
	}
	
	
	
	public static void rotate(int startX,int startY, int endX, int endY) {
		int locIdx = 0;
		int x = startX;
		int y = startY;
		while(true) {
			int nx = x + locs[locIdx][0];
			int ny = y + locs[locIdx][1];
			if(nx < startX|| nx > endX|| ny < startY || ny > endY) {
				locIdx++;
				if(locIdx == 4) break;
				nx = x + locs[locIdx][0];
				ny = y + locs[locIdx][1];
			}
			output[nx][ny] = temp[x][y];
			x = nx;
			y = ny;
		}
		
	}
	
	
	
}
