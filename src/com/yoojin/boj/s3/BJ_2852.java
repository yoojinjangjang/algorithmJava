package com.yoojin.boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2852 {
	static int N; 
	static int curScore = 0;
	static int curWinningTeam = 0;
	static String[] oneWinningTime = new String[2];
	static String[] twoWinningTime = new String[2];
	static int oneTotalTime = 0;
	static int twoTotalTime = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int n = 0;n<N;n++) {
			// 득점 횟수를 반복하며
			StringTokenizer st = new StringTokenizer(br.readLine());
			int winningTeam = Integer.parseInt(st.nextToken());
			String[] winnigTime = st.nextToken().split(":");
			if(winningTeam == 1) {
				curScore += 1;
			} else {
				curScore -= 1;
			}
			
			if(curScore == 0) {
				// 동점인 경우 (승리가 끝남)
				if(curWinningTeam == 1) {
					// TODO: 1번 팀의 득점 후 경과 시간 계산 => 1번 팀의 총 시간 갱신
					oneTotalTime += getExceedTime(oneWinningTime, winnigTime);
				} else {
					// TODO: 2번 팀의 득점 후 경과 시간 계산 => 2번 팀의 총 시간 갱신
					twoTotalTime += getExceedTime(twoWinningTime, winnigTime);
				}
				curWinningTeam = 0;
			} else if(curScore == 1 && curWinningTeam != 1) {
				//  1번팀의 득점 시간 저장
				oneWinningTime = winnigTime;
				// 현재 이기고 있는 팀 = 1
				curWinningTeam = 1;
			} else if(curScore == -1 && curWinningTeam != 2) {
				// 2번팀의 득점 시간 저장
				twoWinningTime = winnigTime;
				// 현재 이기고 있는 팀 = 2
				curWinningTeam = 2;
			}
		}
		
		if(curScore != 0 && curWinningTeam == 1) {
			// TODO: 1번 팀의 득점 후 경과 시간 계산 => 1번 팀의 총 시간 갱신
			oneTotalTime += getExceedTime(oneWinningTime, new String[]{"48","00"});
			
		} else if(curScore != 0 && curWinningTeam == 2){
			// TODO: 2번 팀의 득점 후 경과 시간 계산 => 2번 팀의 총 시간 갱신
			twoTotalTime += getExceedTime(twoWinningTime, new String[]{"48","00"});
		}
		
		System.out.print(oneTotalTime/60<10?"0"+oneTotalTime/60:oneTotalTime/60);
		System.out.print(":");
		System.out.println(oneTotalTime%60 < 10 ? "0"+oneTotalTime%60:oneTotalTime%60);
		
		System.out.print(twoTotalTime/60<10?"0"+twoTotalTime/60:twoTotalTime/60);
		System.out.print(":");
		System.out.println(twoTotalTime%60<10?"0"+twoTotalTime%60:twoTotalTime%60);
	}
	
	static int getExceedTime(String[] winning, String[] current) {
		int win = Integer.parseInt(winning[0]) * 60 + Integer.parseInt(winning[1]);
		int cur = Integer.parseInt(current[0]) * 60 + Integer.parseInt(current[1]);
		return cur - win;
	}
}

/**
 *
 *
5
1 01:10
1 02:20
2 43:30
2 43:40
2 45:50
 *
 */
