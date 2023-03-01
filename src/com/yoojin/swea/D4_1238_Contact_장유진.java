package com.yoojin.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact_장유진 {
	static class Friend {
		int no;
		int depth;
		public Friend(int no, int depth) {
			super();
			this.no = no;
			this.depth = depth;
		}
		
		
	}
	static ArrayList<Integer>[] friends;// 친구의 연결 정보를 담을 리스트
	static boolean[] visited; // 친구의 방문 정보를 담을 리스트
	static int N, start; // 입력 데이터 수, 시작 정점
	static int result; // 결과 값
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testNum = 1;testNum<=10;testNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			friends = new ArrayList[101];
			visited = new boolean[101];
			
			for(int i =0;i<101;i++) {
				friends[i] = new ArrayList<>(); // 친구 연결 정보 리스트 초기화
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N/2;i++) {
				int from  = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(friends[from].contains(to)) continue;
				friends[from].add(to); // 친구 정보 입력으로 갱신
			}
			
			result = Integer.MIN_VALUE;
			depth = 0;
			getFriend(); // 친구들 연결 확인
			
			
			System.out.printf("#%d %d%n",testNum,result);
			
		}
	}

	static int depth = 0;
	private static void getFriend() {
		Queue<Friend> queue = new LinkedList<>();
		queue.add(new Friend(start,0));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			Friend cur = queue.poll();
			if(depth == cur.depth) {
				result = Math.max(result, cur.no);
			} else {
				depth += 1;
				result = Integer.MIN_VALUE;
				result = Math.max(result, cur.no);
			}
			for(int friend : friends[cur.no]) {
				if(visited[friend]) continue;
				visited[friend] = true;
				queue.offer(new Friend(friend, cur.depth+1));
			}
		}
	}
	
}	
