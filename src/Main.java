import java.io.*;
import java.util.*;

class Main {
  static int N, T;
  static int[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    arr = new int[N][2];
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = 1_000_001;
    int ans = Integer.MAX_VALUE;
    while(left <= right) {
      int mid = (left + right) / 2;

      if(can(mid) == 0) {
        right = mid - 1;
        ans = Math.min(ans, mid);
      } else if(can(mid) > 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    if (ans == Integer.MAX_VALUE) {
      ans = -1;
    }
    System.out.println(ans);

  }

  private static int can(int num) {
    int lower = 0, upper = 0;
    for(int i=0; i<N; ++i) {
      if(arr[i][0] > num)  return 1; // num을 늘려야함

      lower += arr[i][0];
      upper += num;
    }

    System.out.println(num + " " + lower + " " + upper);

    if(lower <= T && upper >= T) return 0; // 가능

    else if (lower > T) return -2; // num을 줄여야함
    else return 2;
  }
}