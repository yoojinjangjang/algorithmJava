package com.yoojin.boj.g3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_14658 {
	static int N,M,L,K;
	static ArrayList<Point> stars = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars.add(new Point(x,y));
		}

		// 모든 별의 x,y 좌표를 확인해보아야 한다. 
		
		for(Point point1 : stars) {
			for(Point point2: stars) {
				result = Math.min(result, findStars(point1.x,point2.y));
			}
		}
		
		System.out.println(result);
	}

	private static int findStars(int x, int y) {
		int sum = 0;
		for(Point point: stars) {
			if(point.x >= x && point.x <=x+L && point.y >= y && point.y<=y+L) continue;
			sum++;
		}
		return sum;
	}
}
