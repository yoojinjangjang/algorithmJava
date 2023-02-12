package com.yoojin.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_10867_중복뺴고정렬하기_장유진 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Set<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i =0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i :set) {
			System.out.print(i+" ");
		}
	}
}
