package com.yoojin.permutation;

public class Permutation {
    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) { // n개의 수에서 r개뽑기

        // 모든 순열을 뽑음
        if (depth == r) {
            // 뽑힌 순열 출력하기
            for(int i =0;i<r;i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        // 하나씩 순열에 넣기
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = 4;
        int r = 3;
        int depth = 0;
        int[] output = new int[4];

        permutation(arr, output, new boolean[4], depth, n, r);

    }
}
