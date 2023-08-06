package com.yoojin.boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class BJ_14889_스타트링크 {
    static int N;
    static int[][] map;
    static boolean[] visit;

    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for(int i =0;i<N;i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        combi(0,0);
        System.out.println(MIN);
    }

    private static void combi(int idx, int depth) {
        if(depth == N/2) {
            diff();
            return;
        }

        for(int i = idx;i<N;i++) {
            if(!visit[i]) {
                visit[i] = true;
                combi(i+1,depth+1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for(int i =0;i<N-1;i++) {
            for(int j = i+1; j< N;j++) {
                // i번째 사람과 j번째 사람이 true라면 스타트팀으로 점수 플러스

                if(visit[i] && visit[j]) {
                    teamStart += map[i][j] + map[j][i];
                } else if(!visit[i] && !visit[j]) {
                    teamLink += map[i][j] + map[j][i];
                }
            }
        }

        int diff = Math.abs(teamStart - teamLink);

        if(diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        MIN = Math.min(MIN, diff);
    }

}
