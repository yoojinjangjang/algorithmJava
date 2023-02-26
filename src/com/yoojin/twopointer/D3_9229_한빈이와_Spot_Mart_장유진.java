package com.yoojin.twopointer;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_9229_한빈이와_Spot_Mart_장유진 {
	public static int n,m;
	public static int[] snacks;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("d3_9229.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			StringTokenizer st =new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			snacks = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			
			int s = 0;
			int e = n-1;
			int max = Integer.MIN_VALUE;
			while(s<e) {
				int sum = snacks[s] + snacks[e];
				if (sum <= m) {
					max = Math.max(max, sum);
					s++;
				} else {
					e--;
				}
			}
			
			if(max == Integer.MIN_VALUE) {
				System.out.printf("#%d %d%n",testNum,-1);
			} else {
				
				System.out.printf("#%d %d%n",testNum,max);
			}
		}
	}
}