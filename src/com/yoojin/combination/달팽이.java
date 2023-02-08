package com.yoojin.combination;


import java.util.Scanner;


public class 달팽이 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int T = sc.nextInt();
      int[] dx = {1,0,-1,0}; //남 서 북 동
      int[] dy = {0,-1,0,1};
      
      
      for(int tc = 0; tc < T; tc++) {
         int n = sc.nextInt();
         int[][] arr = new int[n][n];
         boolean[][] visited = new boolean[n][n];
         for(int i = 0; i < n; i++) {
            arr[0][i] = i+1;
            visited[0][i] = true;
         }
         int idx = 0;
         int x = 0;
         int y = n-1;
         int num = n;
         while(num < n*n) { //첫 시작은 아래 방향
            int nx = x + dx[idx] , ny = y + dy[idx];
//            System.out.println("nx : " + nx + "  ny : " + ny);
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) { //방향 change
               idx++;
               if(idx == 4) { 
                  idx = 0;
               }
               nx = x + dx[idx];
               ny = y + dy[idx];
            }
            arr[nx][ny] = ++num;
            x = nx;
            y = ny;
         }
         System.out.println("#"+(tc+1));
         for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
         }
         
      }
   }
}