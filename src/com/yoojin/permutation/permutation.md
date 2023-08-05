# ✅ Permutation [순열]

- 서로 다른 n개에서 r개를 뽑아서 정렬하는 경우의 수 
- `[1,2]` , `[2,1]` 은 순서가 다르기 때문에, 순열에서는 다른것으로 카운팅한다.

### ➡ JAVA 구현
- 순서를 신경쓰는 순열이기 때문에 index 상으로 뒤에 있는 원소가 더 앞에 오는 경우도 카운팅 해야한다. 
- 따라서 탐색을 수행하는 반복문은 0부터 탐색을 시작해야 한다. 
- 또한 순서를 신경쓰는 순열이기 때문에, 순서대로 방문 원소를 저장해야 하므로 선택된 원소를 순서대로 저장한 배열 out을 사용한다. 
- 중복해서 선택하는 것은 불가하므로 visited를 이용하여 이미 선택한 원소를 다시 선택하지 않도록 해준다. 
```java

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
```

# ✅ 중복 순열
- 서로 다른 n개에서 **중복이 가능** 하게 r개를 뽑아서 정렬하는 경우의 수 
- 순서가 있게 뽑는 순열과 동일하지만, 같은 원소를 중복해서 뽑을 수 있다는 차이가 있다. 
- 순열과 유일한 차이가 중복이 가능하다는 것이므로, 순열 코드에서 중복을 방지하기 위해서 사용했던 visited부분을 제거해준다. 
```java
public class Perm {
    public static void perm(int[] arr, int[] output, int depth, int r) {
        if (depth == r) {
            for(int i=0;i<r;i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i =0;i<n;i++) {
            output[depth] = arr[i];
            perm(arr, output, depth+1, r);
    }
}
```
