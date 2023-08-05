# ✅ Permutation [조합]

- 서로 다른 n개의 수에서 **순서없이** r개를 뽑는 경우의 수
- 순서와 상관없다는 말은 순열과 다르게 `[1,2]`, `[2,1]` 는 같은 것으로 취급한다는 것이다.

### ➡ JAVA 구현
- 순서와 상관이 없으므로 `[1,2]` 와 `[2,1]` 이 같다고 했기 때문에 이런 경우 `[1,2]` 만을 카운팅 해준다. 
- 그러기 위해서 현재 선택한 원소보다 뒤에 있는 원소에 대해서만 탐색을 진행해준다. 이를 코드로 구현하기 위해서 탐색의 시작 index를 의미하는 start 원소를 사용해주었다. 
- 탐색의 시작 기준을 start로 해주었다. 탐색의 시작 기준을 start로 해주고, 재귀 호출을 할 때에는 현재 index인 i에 1을 더한 값을 start 로 넣어주었다. 
- 추가적인 특징으로는 순서가 상관이 없고, 중복도 없으므로 선택된 원소를 따로 저장하지 않고, 원소들과 visited만 이용하여 방문한 원소들을 순서대로 확인하면 곧 선택된 조합이다.
```java
package com.yoojin.combination;

public class Combination {
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

```

# ✅ 중복 조합
- 서로 다른 n개에서 순서 없이, **중복이 가능** 하게 r개를 뽑는 경우의 수 
- 순서 없이 뽑는 조합과 동일하지만, 이미 뽑은 것을 또 뽑을 수 있다는 중복이 가능하다는 차이가 있다. 

```java
public class Combi {
    public static void combi(int[] arr, int[] output, int start, int depth, int r) {
        if(depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = start; i< n; i++) {
            output[depth] = arr[i];
            combi(arr, output, i, depth + 1, r);
        }
    }
        
}
```