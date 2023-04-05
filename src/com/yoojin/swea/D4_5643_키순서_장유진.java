package com.yoojin.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_5643_키순서_장유진 {
	static ArrayList<ArrayList<Integer>> highFreinds = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> lowFreinds = new ArrayList<>();
	static int[] highCnt;
	static int[] lowCnt;
	static int N,M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			highFreinds = new ArrayList<>();
			lowFreinds = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			for(int i=0;i<N;i++) {
				highFreinds.add(new ArrayList<>());
				lowFreinds.add(new ArrayList<>());
			}
			
			highCnt = new int[N];
			lowCnt = new int[N];
			StringTokenizer st;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				highFreinds.get(a).add(b);
				lowFreinds.get(b).add(a);
				
			}
			
			for(int i=0;i<N;i++) {
				highBfs(i);
				lowBfs(i);
			}
			
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				if(highCnt[i] + lowCnt[i] == N-1) cnt++;
			}
			
			bw.write("#" + testNum + " " + cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void lowBfs(int start) {
		visited= new boolean[N];
		visited[start] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i =0;i<lowFreinds.get(cur).size();i++) {
				if(visited[lowFreinds.get(cur).get(i)]) continue;
				visited[lowFreinds.get(cur).get(i)] = true;
				queue.add(lowFreinds.get(cur).get(i));
				lowCnt[start]++;
			}
		}
		
	}
	private static void highBfs(int start) {
		visited= new boolean[N];
		visited[start] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i =0;i<highFreinds.get(cur).size();i++) {
				if(visited[highFreinds.get(cur).get(i)]) continue;
				visited[highFreinds.get(cur).get(i)] = true;
				queue.add(highFreinds.get(cur).get(i));
				highCnt[start]++;
			}
		}
	}
}
