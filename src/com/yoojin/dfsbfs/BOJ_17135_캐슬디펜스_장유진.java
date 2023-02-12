package com.yoojin.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스_장유진 {
	static int N; // N행
	static int M; // M행
	static int D; // 쏠수 있는 거리
	
	static int[][] maps; // 거리 배열
	static boolean[][] visited; //방문 배열
	
	static int[] pickArcher; // 현재 조합에서 선택된 궁수들 
	static int cnt; // 해당 조합에서 잡은 적의 수 
	static int max = Integer.MIN_VALUE; // 잡은 적의 수의 최대값 
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		pickArcher = new int[3];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0;j<M;j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pickArcher(0,0); // 메서드 시작 
		
		System.out.println(max);
		
	}
	/**
	 * 궁수의 조합을 선택하는 메서드 
	 * @param start 
	 * @param depth
	 */
	private static void pickArcher(int start, int depth) {
		if(depth==3) {
			// 3개를 픽했으면 해당 궁수의 위치를 가지고 적들을 죽이는 메소드 실행
			killEnemy();
			max = Math.max(max, cnt); // 한 조합을 수행하고 최대값 갱신
			return;
		}
		
		for(int i = start;i<M;i++) {
			pickArcher[depth] = i; // 1부터 M까지의 수 중 선택
			pickArcher(i+1,depth+1); 
		}
		
	}
	/**
	 * 배열 갱신 
	 */
	static int[][] usingMaps;
	private static void reset() {
		visited = new boolean[N][M];
		usingMaps = new int[N][M];
		for(int i = 0;i<N;i++) {
			System.arraycopy(maps[i],0,usingMaps[i],0,M);
		}
	}
	
	/**
	 * 적을 죽이는 메서드
	 */
	static int[][] locs = {{0,-1},{-1,0},{0,1}}; // 사방 탐색 위한 좌표
	static Queue<Point> queue;
	static PriorityQueue<Point> canKillEnemyQueue;
	static List<Point> canKillEnemyList;
	private static void killEnemy() {
		reset(); // map 배열과 visited 배열 갱신
		cnt = 0;
		for(int archerX = N;archerX > 0; archerX--) { // 궁수의 x열을 N부터 1까지 반복하며 궁수의 위치를 바꿔줌 
			// 궁수 별로 큐를 갱신 해주어야 함
			boolean flag = false; // 적이 남아있는지 확인하는 플래그(false -> 남아있지 않음, true -> 남아있음)
			
			if(archerX != N) { // 궁수의 위치를 위로 올린 경우 해당 값들을 모두 0으로 변경해주고 방문배열도 방문표시해준다. 
				for(int i = 0;i<M;i++) {
					usingMaps[archerX][i] = 0;
				}
			}
			canKillEnemyList = new ArrayList<Point>(); // 궁수별 죽일 수 있는 적의 위치를 담는 배열
			for(int archerNum = 2;archerNum >=0;archerNum--) { // 각 궁수의 위치 별로 적을 찾는다.
				visited = new boolean[N][M]; // 각 궁수의 위치 별로 탐색을 다시 하기 때문에  갱신
				queue = new LinkedList<>();
				canKillEnemyQueue = new PriorityQueue<>();
				
				if(archerX != N) {
					for(int i = 0;i<M;i++) {
						visited[archerX][i] = true;
					}
					 // 궁수의 위치 방문 처리 
				}
				queue.offer(new Point(archerX,pickArcher[archerNum],0)); // 현재 궁수의 위치를 큐에 삽입
				while (!queue.isEmpty()) { // 큐에 값이 있으면 반복
					
					Point cur = queue.poll(); // 큐에서 빼기
					
					for(int[] loc:locs) { // 사방을 탐색
						int nx = cur.getX() + loc[0]; 
						int ny = cur.getY() + loc[1]; 
						if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; //범위 검사
						
						if(!visited[nx][ny]) { // 방문하지 않은 경우
							queue.offer(new Point(nx,ny,0));
							visited[nx][ny] = true;
							if (usingMaps[nx][ny] == 1) { // 적인경우
								flag = true; // 적이 있다는 표시 하기 
								int distance = Math.abs(archerX-nx) + Math.abs(pickArcher[archerNum]-ny);
								if (distance <= D) { // 거리 안에 있는 경우
									canKillEnemyQueue.offer(new Point(nx,ny,distance));
								}
							}
						}
					}
				} // 큐 종료
				
				if(!canKillEnemyQueue.isEmpty()) { // 적이 있는 경우
					Point enemy = canKillEnemyQueue.poll(); 
					canKillEnemyList.add(enemy); // 죽일 수 있는 적을 리스트에 담기 
				}
			} // 궁수의 위치 별 반복 종료
			
			// 모든궁수에 대해 반복이 종료된 경우 죽일수있는 적들의 배열을 돌며 해당 값을 0으로 바꿔주고 1인 경우 카운트를 증가시키기
			canKillEnemyList.forEach(enemy -> {
				if (usingMaps[enemy.getX()][enemy.getY()] == 1) cnt++;
				usingMaps[enemy.getX()][enemy.getY()] = 0;
			});
			
			if (!flag) { // 찾은 적이 없는 경우
				break; // 궁수의 행을 올리지 않고 종료한다. 
			}
		} // 궁수 열별 반복 종료
	}
		
}

class Point implements Comparable<Point>{
	private int x;
	private int y;
	private int disatance;
	
	public Point(int x, int y, int disatance) {
		super();
		this.x = x;
		this.y = y;
		this.disatance = disatance;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDisatance() {
		return disatance;
	}
	public void setDisatance(int disatance) {
		this.disatance = disatance;
	}
	@Override
	public int compareTo(Point o) {
		if(this.disatance != o.disatance) {
			return Integer.compare(this.disatance, o.disatance);
		}
		return Integer.compare(this.y, o.y);
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", disatance=" + disatance + "]";
	}
	
	
	
}