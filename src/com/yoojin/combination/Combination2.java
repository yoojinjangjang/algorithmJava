package com.yoojin.combination;

public class Combination2 {
    public static void combination(int[] arr, boolean[] visited, int start, int depth, int n, int r) {

        // 모든 조합을 다 뽑음
        if(depth == r) {
            for(int i=0;i<n;i++) {
                if(visited[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        // 하나씩 반복하며 넣기
        for(int i = start;i < n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i+1, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = 4, r = 3;
        int start = 0, depth = 0;
        combination(arr, new boolean[4], start, depth, n, r);
    }
}
