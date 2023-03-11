package com.yoojin.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107 {
	static int N,M;
	static String brokens;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M!=0) {
			brokens = br.readLine().replace(" ", "").trim();
		}
		if(N == 100) {
			System.out.println(0);
			return;
		}
		getChannelCnt();
		
		System.out.println(result);
	}
	
	private static void getChannelCnt() {
		for(int channel=0;channel<=999_999;channel++) {
			result = Math.min(result, Math.abs(N-100));
			boolean flag = true;
			for(int i =0;i<M;i++) {
				if(String.valueOf(channel).contains(""+brokens.charAt(i)))  {
					// 고장난 버튼이 있는 경우 해당 채널로 바로 이동 불가
					flag = false;
					break;
				}
			}
			
			if(flag) {
				// 고장난 버튼이 없는 경우 
				int diff = Math.abs(N-channel);
				result = Math.min(result, diff+String.valueOf(channel).length());
			}
		}
	}
	
	

	

}	
