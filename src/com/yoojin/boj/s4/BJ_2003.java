package com.yoojin.boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2003 {
    static int N,M;
    static int[] arr;
    static int sum; // 현재까지의 총합
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cnt = 0;
        for(int num = 1;num <= N; num++) {
            int l = 0;
            int r = num;
            sum = 0;
            for (int i = l; i < r; i++) {
                sum += arr[i];
            }

            if (sum == M) cnt++;
            while (r < N) {
                sum -= arr[l++];
                sum += arr[r++];
                if (sum == M) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
