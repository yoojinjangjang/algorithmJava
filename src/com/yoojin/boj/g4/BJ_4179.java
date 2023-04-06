package com.yoojin.boj.g4;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179 {
	static Queue<Point> fires = new LinkedList<>();
	static Queue<Point> jihun = new LinkedList<>();
	static int[][] fireTime;
	static int[][] jihunTime;
	static int R,C;
	static char[][] maze;
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] visited;
	static int[][] locs = {{-1,0},{0,1},{1,0},{0,-1}};
	static int result = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];
		fireTime = new int[R][C];
		jihunTime = new int[R][C];
		for(int i=0;i<R;i++) {
			Arrays.fill(fireTime[i], INF);
			Arrays.fill(jihunTime[i], INF);
		
		}
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j =0;j<C;j++) {
				maze[i][j] = line.charAt(j);
				if (maze[i][j] == 'F'){
					fires.offer(new Point(i,j));
					fireTime[i][j] = 0;
					visited[i][j] = true;
				} else if(maze[i][j] == 'J') {
					jihun.offer(new Point(i,j));
					jihunTime[i][j] = 0;
				}
			}
		}
		
		
		// 1. 불의 시간 구하기
		bfsFire(fires);
		
//		for(int i=0;i<R;i++) {
//			for(int j =0;j<C;j++) {
//				System.out.print(fireTime[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		// 2. 지훈이의 시간 구하기
		visited = new boolean[R][C];
		bfsJihun(jihun);
		
//		for(int i=0;i<R;i++) {
//			for(int j =0;j<C;j++) {
//				System.out.print(jihunTime[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		
		// 3. 가장자리중 지훈이의 최대 이동 시간 구하기 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(i== 0 || i == R-1 || j == 0 || j == C-1) {
					// 가장자리인 경우
					// 지훈이의 도착시간이 불의 도착시간보다 빠른 경우 값 갱신
					if(jihunTime[i][j] < fireTime[i][j]) {
						result = Math.min(result, jihunTime[i][j] + 1);
					}
				}
			}
		}
		if(result == INF) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
			
		}
	
	}

	private static void bfsJihun(Queue<Point> queue) {
		Point start = queue.peek();
		visited[start.x][start.y]= true; 
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int[] loc:locs) {
				int nx = cur.x + loc[0];
				int ny = cur.y + loc[1];
				if(notInRange(nx, ny)) continue;
				if(visited[nx][ny]) continue;
				if(fireTime[nx][ny] <= jihunTime[cur.x][cur.y]+1) {
					jihunTime[nx][ny] = INF;
					continue;
				}
				if(maze[nx][ny] == '#') continue;
				visited[nx][ny] = true;
				jihunTime[nx][ny] = jihunTime[cur.x][cur.y]+ 1;
				queue.offer(new Point(nx,ny));
			}
		}
	}

	private static void bfsFire(Queue<Point> queue) {
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int[] loc:locs) {
				int nx = cur.x + loc[0];
				int ny = cur.y + loc[1];
				if(notInRange(nx,ny)) continue;
				if(visited[nx][ny]) continue;
				if(maze[nx][ny] == '#') continue;
				visited[nx][ny] = true;
				fireTime[nx][ny] = fireTime[cur.x][cur.y]+ 1;
				queue.offer(new Point(nx,ny));
			}
			
		}
		
	}

	private static boolean notInRange(int nx, int ny) {
		return nx < 0 || nx >= R || ny < 0 || ny >= C;
	}
}

/*
4 4
####
#J.#
#..#
#..#

*/