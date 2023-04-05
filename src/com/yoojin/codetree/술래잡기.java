package com.yoojin.codetree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 술래잡기 {
	// n, m, h, k
	static int[][] maps;
	static int N,M,H,K; // 행렬 크기, 도망자 수, 나무 수, 시간 초
	static int rotationCnt = 0; // 회전한 횟수 (2일 경우 이동 횟수를 증가시킨다.)
	static int maxMove = 1; // 최대 이동 횟수 
	static int move = 0; // 현재 이동 횟수
	static int taggerLocsIdx = 0; // 술래의 현재 이동 방향 배열 인덱스
	static int taggerPlusOrMinus = 1; // 술래가 현재 바깥 달팽이 이동인지, 안쪽 달팽이 이동인지 구별하는 인덱스
	static int[][] locs = {{-1,0},{0,1},{1,0},{0,-1}}; // 도망자들의 이동 배열 : 상 우 하 좌 
	static int[][][] taggerLocs = { // 술래의 이동 배열
			{{-1,0},{0,1},{1,0},{0,-1}}, // 상, 우, 하, 좌 
			{{1,0},{0,1},{-1,0},{0,-1}}  // 하, 우, 상, 좌
	};
	static int result = 0;
	static Person tagger; 
	static List<Person> runners = new ArrayList<>();
	static int maxRotation = 2;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		maps = new int[N][N]; // 지도 배열 
		tagger = new Person(N/2, N/2, 0); // 술래 생성
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			runners.add(new Person(x,y,d)); // 도망자 입력
		}
		
		for(int i=0;i<H;i++) {
			// tree의 위치를 1로 만들기
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			maps[x][y] = 1;
		}
		
		
		// 게임 실행
		doGame();
		
		// 출력
		System.out.println(result);
	}
	
	private static void doGame() {
		// k번 반복하며 수행
		for(int k =1;k<=K;k++) {
			// 1. 도망자 이동
			moveRunner();
//			System.out.println();
//			System.out.println(runners.toString());
			// 2. 술래 이동
			moveTagger();
			
//			System.out.print(k+ " ");
//			System.out.print(tagger + "     " + taggerLocsIdx + "   ====  ");
		   // 3. 술래가 도망자 잡기
			catchRunner(k);
//			System.out.println();
//			System.out.println();
			// 4. 모든 도망자 잡은 경우 break;
			if(runners.isEmpty()) break;
		}
		
	}

	private static void catchRunner(int curTime) {
		int catchCount = 0;
		int taggerX = tagger.x;
		int taggerY = tagger.y;
		int cnt = 0;
		while(cnt < 3) {
			int nx = taggerX;
			int ny = taggerY;
			
			if(notInRange(nx, ny)) break;
			
			if(maps[nx][ny] != 1) {
				// tree가 없음
				// 도망자 있는 경우 도망자 잡기
				while(runners.remove(new Person(nx,ny,0))) {
//					System.out.print(new Person(nx,ny,0)+ "    :    ");
					catchCount++;
				}
			}
			
			taggerX = taggerX + taggerLocs[taggerLocsIdx][tagger.d][0];
			taggerY = taggerY + taggerLocs[taggerLocsIdx][tagger.d][1];
			cnt++;
		}
		
		result += (curTime * catchCount);
//		System.out.print(result + "  ");
	}

	private static void moveTagger() {
		tagger.x = tagger.x + taggerLocs[taggerLocsIdx][tagger.d][0];
		tagger.y = tagger.y + taggerLocs[taggerLocsIdx][tagger.d][1];
		
		move++;
		if(move == maxMove) {
			// 이동 다한 경우
			tagger.d = (tagger.d + 1) %4;
			rotationCnt++;
			move = 0;
		}
		
		if(rotationCnt == maxRotation) {
			if(maxRotation == 3) maxRotation = 2;
			maxMove += taggerPlusOrMinus;
			rotationCnt = 0;
		}
		
		if(tagger.x == 0 && tagger.y == 0  || tagger.x == N/2 && tagger.y == N/2) {
			// 끝에 도달하거나 중간에 도달한 경우 
			tagger.d = 0;
			taggerLocsIdx = taggerLocsIdx==0?1:0; // 0이면 1로 1이면 0으로
			taggerPlusOrMinus *=  -1;
			
			maxMove += taggerPlusOrMinus;
			move = 0;
			rotationCnt = 0;
			if(taggerLocsIdx == 1) maxRotation = 3;
		}
		
	}

	private static void moveRunner() {
		for(int i=0;i<runners.size();i++) {
			Person runner = runners.get(i);
			
			int distRunnerAndTagger = Math.abs(runner.x-tagger.x)+ Math.abs(runner.y - tagger.y); 
			
			if(distRunnerAndTagger <= 3) {
				// 3이하인 경우 도망자 이동
				if(notInRange(runner.x + locs[runner.d][0], runner.y + locs[runner.d][1])) {
					// 범위를 벗어난 경우 
					runner.d = (runner.d + 2) %4;
				}
				
				int nx = runner.x + locs[runner.d][0];
				int ny = runner.y + locs[runner.d][1];
				if(nx != tagger.x || ny != tagger.y) { // 도망자 이동 위치가 술래의 위치가 아닌 경우 
					runner.x = nx;
					runner.y = ny;
				}
			}
		}
	}

	private static boolean notInRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}

	static class Person {
		int x,y,d;

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", d=" + d + "]";
		}

		public Person(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
	}
}