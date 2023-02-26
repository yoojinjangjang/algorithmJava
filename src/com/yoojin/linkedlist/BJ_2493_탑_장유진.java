package com.yoojin.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
class Top {
	int height;
	int index;
	public Top(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}
	
}

public class BJ_2493_탑_장유진 {
	static int N;
	static int[] arr;
	static int[] output;
	static Stack<Top> stack = new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		 arr = new int[N];
		 output = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(new Top(arr[0],1)); // 첫번째 탑 넣어두기 
		output[0] = 0;
		for(int i = 1;i<N;i++) {
			while(!stack.isEmpty()) {
				Top beforeTop = stack.pop();
				if(beforeTop.height >= arr[i]) {
					output[i] = beforeTop.index;
					stack.push(beforeTop);
					break;
				} 
			}
			stack.push(new Top(arr[i],i+1));
		}
		
		for(int i = 0;i<N;i++) {
			System.out.print(output[i]+ " ");
		}
		
		
	}
}