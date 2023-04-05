package com.yoojin.boj.g4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥_장유진 {
	static int N, d, k, c;
	static int[] sushis;
	static int[] kinds; 
	static int cnt;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushis = new int[N];
		kinds = new int[d+1];
		kinds[c] = 1;
		cnt = 1;
		
		for(int i=0;i<N;i++) {
			sushis[i] = Integer.parseInt(br.readLine());
			if(i < k ) {
				if(kinds[sushis[i]] == 0) cnt++;
				kinds[sushis[i]]++;
				
			}
		}
		
		result = Math.max(result, cnt);
		
		int start = 0;
		int end = k%N;
		
		while(start < N) {
			if(kinds[sushis[start]] == 1) {
				cnt--;
			}
			kinds[sushis[start]]--;
			
			if(kinds[sushis[end]] == 0) {
				// 넣는게 0인 경우 
				cnt++;
			}
			kinds[sushis[end]]++;
			
			start += 1;
			end = (end+1)%N;
			
			result = Math.max(result, cnt);
			
		}
		
		
		System.out.println(result);
	}
}