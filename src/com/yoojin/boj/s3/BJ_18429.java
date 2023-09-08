package com.yoojin.boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
3 4
3 7 5

* */
public class BJ_18429 {
    static int N;
    static int K;
    static int[] weight;
    static int result;

    static boolean[] visited;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        result = 0;
        visited = new boolean[N];
        output = new int[N];
        permutation(0);

        System.out.println(result);
    }

    static void permutation(int cnt) {
        if(cnt == N) {
            // 해당 순열이 가능한지 확인한다.
            check();
            return;
        }

        for(int i=0;i<N;i++) {
            if(visited[i]) continue;;
            visited[i] = true;
            output[cnt] = weight[i];
            permutation(cnt+1);
            visited[i] = false;
        }
    }

    private static void check() {
        int curWeight = 500;
        for(int i=0;i<N;i++) {
            curWeight -= K;
            curWeight += output[i];
            if(curWeight < 500) return;
        }
        result++;
    }
}
