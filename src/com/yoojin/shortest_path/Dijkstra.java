package com.yoojin.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Dijkstra {
	static class Node implements Comparable<Node> { 
		int index;
		int distance;
		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
		public int getIndex() {
			return index;
		}
		public int getDistance() {
			return distance;
		}
		@Override
		public int compareTo(Node other) {
			if(this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
		
	}
	private static final int INF = (int)1e9; // 무한대의 수 
	private static int n,m,start; // n개의 노드, m개의 간선, start 시작위치
	// 연결 노드의 정보를 담을 리스트
	private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	private static int[] d = new int[100001]; // 최단 거리 테이블
	
	public static void dijkstra(int start) {
		// 우선순위 큐 생성
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start] = 0; //시작 노드는 거리 0
		pq.offer(new Node(start,0)); 
		while(!pq.isEmpty()) {
			// 큐가 비지 않을 떄까지 
			Node node = pq.poll(); // 꺼내기
			int dist = node.getDistance();
			int now = node.getIndex();
			if(d[now] < dist) { 
				continue; // 이미 최소 거리가 계산된 경우 무시
			}
			// 현재 노드와 연결된 모든 노드에 대해 확인
			for(int i=0;i<graph.get(now).size();i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < graph.get(now).get(i).getDistance()) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(),cost));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		//그래프 초기화
		for(int i = 0;i<n;i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//모든 간선 정보 입력
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b,c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for(int i =1 ;i<=n;i++) {
			if(d[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}
