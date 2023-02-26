package com.yoojin.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드_장유진 {
	
	static int H,W; // 높이, 너비
	static int N; // 명령어 개수
	static char[][] maps; // 해당 전차 맵 배열
	static int x,y; // 전차 현재 위치
	static Map<Character,Character> tankRotation = new HashMap<Character, Character>() {{
		put('U','^');
		put('D','v');
		put('L','<');
		put('R','>');
	}};
	
	static Map<Character,Integer[]> tankLocation = new HashMap<Character,Integer[]>(){{
		put('^',new Integer[] {-1,0});
		put('v',new Integer[] {1,0});
		put('<',new Integer[] {0,-1});
		put('>',new Integer[] {0,1});
	}};
	
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("d3_1873.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			maps = new char[H][W];
			for(int i =0;i<H;i++) {
				String str = in.readLine();
				for(int j = 0;j<W;j++) {
					maps[i][j] = str.charAt(j);
					if(maps[i][j] == '^' || maps[i][j] == 'v' || maps[i][j] == '<' || maps[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			
			
			N = Integer.parseInt(in.readLine());
			String instructions = in.readLine();
			for(int i = 0;i<N;i++) {
				char inst = instructions.charAt(i);
				if(inst != 'S') { // 발사가 아니면
					maps[x][y] = tankRotation.get(inst); // 현재 탱크의 모양 변경
					int nx = x + tankLocation.get(maps[x][y])[0];
					int ny = y + tankLocation.get(maps[x][y])[1]; 
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) {
						// 범위를 벗어난 경우 
						continue; // 아무일도 하지 않음
					}
					if(maps[nx][ny]!='.') {
						// 전차가 이동가능한 평지가 아닌 경우
						continue; // 아무일도 하지 않음
					}
					// 전차 이동 가능인 경우
					maps[x][y] = '.'; // 현재 전차의 위치를 평지로 변경하고
					maps[nx][ny] = tankRotation.get(inst); // 전차의 위치를 변경하고
					x = nx;
					y = ny; // 현재 저장 전차 위치 변경
				} else {
					// 슈팅인 경우
					Integer[] loc = tankLocation.get(maps[x][y]); // 현재 전차의 방향을 확인하고
					int sx = x;
					int sy = y; // 포탄의 위치
					while(true) {
						int nx = sx + loc[0];
						int ny = sy + loc[1];
						if(nx < 0 || nx >= H || ny < 0 || ny >= W) break; // 포탄이 밖으로 나간 경우 종료
						if(maps[nx][ny] == '*') {
							// 벽돌 벽인 경우
							maps[nx][ny] = '.'; // 평지로 변경 후 종료
							break;
						}
						if(maps[nx][ny] == '#') {
							// 강철 벽인 경우 종료
							break; 
						}
						sx = nx;
						sy = ny;
					}
					
				}
			}
			
			// 모두 수행 후 
			System.out.print("#" + testNum+" ");
			for(int i =0;i<H;i++) {
				for(int j = 0;j<W;j++) {
					System.out.print(maps[i][j]);
				}
				System.out.println();
			}
		}
	}
}
