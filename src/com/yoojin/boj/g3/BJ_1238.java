package com.yoojin.boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BJ_1238: 파티
 * 풀이시작: 8:00
 * 풀이 시간: 40분
 */
public class BJ_1238 {
	static final int INF = (int)1e9;
	
	static int N,M,X;
	
	static ArrayList<ArrayList<QueueNode>> graph = new ArrayList<ArrayList<QueueNode>>();
	static int[][] d;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{

		
		init();
		
		for(int i =0;i<N;i++) {
			dijkstra(i);
		}
		
		
		for(int i=0;i<N;i++) {
			int sum = d[i][X] + d[X][i];
			// 학생들이 x로 갔다가 다시 오는 시간 계산
			
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
	}
	
	
	
	private static void dijkstra(int start) {
		d[start][start] = 0;
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		pq.offer(new QueueNode(start, 0));
		
		while(!pq.isEmpty()) {
			QueueNode cur = pq.poll();
			
			int idx = cur.index;
			int dist = cur.time;
			
			if(d[start][idx] < dist) {
				continue;
			}
			
			for(int i =0;i<graph.get(idx).size();i++) {
				int cost = d[start][idx] + graph.get(idx).get(i).time;
				if(cost < d[start][graph.get(idx).get(i).index]) {
					d[start][graph.get(idx).get(i).index] = cost;
					pq.offer(new QueueNode(graph.get(idx).get(i).index, cost));
				}
			}
		}
	}



	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		
		d = new int[N][N];
		for(int i =0;i<N;i++) {
			Arrays.fill(d[i], INF);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			
			graph.get(to).add(new QueueNode(from, time));
		}
	}



	static class QueueNode implements Comparable<QueueNode>{
		int index;
		int time;
		@Override
		public String toString() {
			return "QueueNode [index=" + index + ", time=" + time + "]";
		}
		public QueueNode(int index, int time) {
			super();
			this.index = index;
			this.time = time;
		}
		@Override
		public int compareTo(QueueNode o) {
			return Integer.compare(this.time, o.time);
		}
		
	}
}
