package com.yoojin.boj.s1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_7562 {
    static int size;
    static int[] night;
    static int[] target;
    static int[][] arr;
    static Integer MIN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        for(int test = 1;test <= testNum; test++) {
            size = Integer.parseInt(br.readLine());
            night = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr = new int[size][size];

            for(int i=0;i<size;i++) {
                for(int j = 0;j<size;j++) {
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
            MIN = Integer.MAX_VALUE;
            arr[night[0]][night[1]] = 0;

            bfs(new Point(night[0],night[1]));
            System.out.println(arr[target[0]][target[1]]);


        }
    }
    public static int[][] loc = new int[][]{{-2,1},{-1,2}, {1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public static void bfs(Point start) {
        Deque<Point> queue = new LinkedList<>();
        queue.add(start);
        arr[start.x][start.y] = 0;

        while(!queue.isEmpty()) {
            // 큐가 비지 않을때까지
            Point cur = queue.pop();

            for(int[] pos: loc) {
                int nx = cur.x + pos[0];
                int ny = cur.y + pos[1];
                if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                if(arr[nx][ny] <= arr[cur.x][cur.y]+1) continue;
                arr[nx][ny] = arr[cur.x][cur.y] + 1;
                queue.offer(new Point(nx,ny));
            }
        }

    }
}

/*
2
100
0 0
30 50
10
1 1
1


*/