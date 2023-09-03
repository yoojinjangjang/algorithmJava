package com.yoojin.boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10974 {
    // 모든 순열
    // 순열: 순서가 있는 숫자 열
    static int[] output;
    static boolean[] visited;

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        output = new int[N];
        permutation(0);
    }

    static void permutation(int cnt) {
        if(cnt == N) {
            // 모든 순열을 다 뽑음
            for(int i =0;i<N;i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i =0;i<N;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            output[cnt] = i+1;
            permutation(cnt+1);
            visited[i] = false;
        }
    }
}
