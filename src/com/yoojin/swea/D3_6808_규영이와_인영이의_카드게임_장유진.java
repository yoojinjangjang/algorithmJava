package com.yoojin.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.Position.Bias;

public class D3_6808_규영이와_인영이의_카드게임_장유진 {
	public static int[] kyoung;
	public static int[] iyoung;
	
	public static int[] winOrLose; 
	public static boolean[] visited;
	public static int[] output;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("d3_6808.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int testNum = 1;testNum<=T;testNum++) {
			kyoung = new int[9];
			iyoung = new int[9];
			kyoung = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); // 규영이의 배열 입력
			int idx = 0;
			int iIdx = 0;
			
			for(int i = 1;i<=18;i++) { //인영이의 배열 생성
				if(idx < 9 && kyoung[idx] == i) {
					idx++;
					continue;
				}
				if (iIdx >= 9) break;
				iyoung[iIdx] = i;
				iIdx++;
			}
			// 순열에 사용할 배열 초기화 
			visited = new boolean[9]; // 인영이 방문 배열
			output = new int[9]; // 인영이 순열 배열 
			winOrLose = new int[2]; // 0 : win, 1: lose
			// 순열을 만들고 해당 순열과 규영이의 배열에 대한 게임 점수 계산 하여 이기는 경우와 지는 경우수를 계산
			permutation(0);
			System.out.printf("#%d %d %d%n",testNum,winOrLose[0],winOrLose[1]);
		}
	}
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			// 순열 생성 => 각 순열 별로 규영이가 졌는지 이겼는지를 판단
			// output 배열과 규영이 배열과의 승자,패자 점수 계산
			int result = doGame();
			if(result == 1) {
				// return 이 1인 경우 규영이 승 => winOrLose[0]을 증가
				winOrLose[0]++;
			} else if (result == 0) {
				// return 이 0인 경우 규영이 패 => winOrLose[1]을 증가 
				winOrLose[1]++;
			}
			
			// return 이 2인 경우 무승부 => 암짓도 안함
			return;
		}
		
		for(int i =0;i<9;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[cnt] = iyoung[i];
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	public static int doGame() {
		// output 배열: 인영이의 게임 카드
		// kyoung 배열 : 규영이의 게임 카드
		int kyoungScore = 0;
		int iyoungScore = 0;
		// 각 9개의 카드를 모두 확인하여 큰 숫자를 가진 사람의 점수에  두 카드의 합을 증가 
		// 진 경우 continue 
		for(int i =0;i<9;i++) {
			if (kyoung[i] > output[i]) {
				// 규영이의 점수가 큰 경우
				kyoungScore += kyoung[i] + output[i];
			} else {
				// 인영이의 점수가 큰 경우
				iyoungScore += kyoung[i] + output[i];
			}
		}
		
		if(kyoungScore > iyoungScore) {
			// 둘 중에 높은 점수를 가진 사람이 규영이인 경우 return 1 (승)
			return 1;
		} else if (kyoungScore < iyoungScore) {
			// 둘 중에 작은 점수를 가진 사람이 인영이인 경우 return 0 (패)
			return 0;
		} else {
			// 둘이 같은 점수를 가진 경우 return 2; (무승부)
			return 2;
		}
	}
}
