package com.yoojin.boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15886 {
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i =0;i<N-1;i++) {
            if(str.charAt(i) == 'E' && str.charAt(i+1) == 'W') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
