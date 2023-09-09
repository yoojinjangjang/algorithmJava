package com.yoojin.boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_5567 {
    static int n; // 친구 수
    static int m; // 리스트 수
    static List<List<Integer>> graph = new ArrayList<>(); // 친구 관계 리스트
    static boolean[] friendYn; // 이미 친구인지 여부
    static int totalCnt; // 총 초대할 친구의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        // 초기화 부터
        for(int i =0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i =0;i<m;i++) {
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a와 b는 친구관계이다.
            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }
        friendYn = new boolean[n];
        friendYn[0] = true;
        for(int friend: graph.get(0)) {
            if(!friendYn[friend]) {
                totalCnt++;
            }
            friendYn[friend] = true; // 내친구임
            for(int other: graph.get(friend)) {
                if(friendYn[other]) continue;
                totalCnt++;
                friendYn[other] = true;
            }
        }

        System.out.println(totalCnt);

    }
}