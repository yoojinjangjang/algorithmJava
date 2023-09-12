package com.yoojin.boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19941 {
    static int N,K;
    static int[] arr;
    static int[] arr2;
    static int cnt = 0;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        arr2 = new int[N];
        String str = br.readLine();
        for(int i =0;i<N;i++) {
            if(str.charAt(i) == 'H') {
                // 햄버거임
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            //System.out.print(arr[i]+" ");
        }

        for(int i =0;i<N;i++) {
            // 한개씩 돌면서 사람일 경우에
            if(arr[i] == 0) {
                for(int k = K;k>0;k--) {
                    int nx = i  - k;
                    if(nx < 0) continue; // 0보다 작은 경우 다음 거 확인하기
                    if(arr[nx] == 1) {
                        // 햄버거임
                        cnt++;
                        arr[nx] = -1;
                        arr[i] = -2;
                        break;
                    }
                }

                for(int k = 1;k<=K;k++) {
                    if(arr[i] == -2) break;
                    int nx = i  + k;
                    if(nx >= N) continue; // 0보다 작은 경우 다음 거 확인하기
                    if(arr[nx] == 1) {
                        // 햄버거임
                        cnt++;
                        arr[nx] = -1;
                        arr[i] = -2;
                        break;
                    }
                }
            }
        }






        System.out.println(cnt);



    }
}
