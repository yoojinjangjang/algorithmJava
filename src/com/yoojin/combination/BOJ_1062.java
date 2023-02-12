package com.yoojin.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062 {
	static int N;
	static int K;
	static List<Character> contains;
	static String[] strings;
	static char[] alphabets = {'b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z'};
	static boolean[] visited = new boolean[21];
	static int cnt;
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		strings = new String[N];
		for(int i = 0;i<N;i++) {
			strings[i] = in.readLine();
		}
		combination(0, 0);
		if (MAX == Integer.MIN_VALUE) {
			System.out.println(0);
		}else System.out.println(MAX);
		
		
	}
	
	public static void combination(int start, int depth) {
		if(depth==K-5) {
			contains = new ArrayList<Character>(Arrays.asList('a','n','t','i','c'));
			cnt = 0;
			// 해당 조합을 이용하여 문자열 검사
			for(int i =0;i<alphabets.length;i++) {
				if(visited[i]) {
					contains.add(alphabets[i]);
				}
			}
			doCheckContain();
			MAX = Math.max(MAX, cnt);
			return;
		}
		
		
		for(int i = start;i<alphabets.length;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combination(i+1, depth+1);
			visited[i] = false;
		}
		
	}

	private static void doCheckContain() {
		
		for(int i = 0;i<N;i++) {
			boolean flag = false;
			for(int j = 4;j<=strings[i].length()-5;j++) {
				if (!contains.contains(strings[i].charAt(j))) {
					flag = true;
					break;
				}
			}
			if(!flag) cnt++;
		}
		
		
	}
}
