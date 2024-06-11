package C01Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SelectionSort {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    int i = 0;
    while(st.hasMoreTokens()) {
      arr[i++] = Integer.parseInt(st.nextToken());
    }

    selectionSort(arr);

    System.out.println(Arrays.toString(arr));
  }


  private static void selectionSort(int [] arr) {
    int len = arr.length;
    for(int i=0; i<len-1; ++i) {
      int minVal = Integer.MAX_VALUE;
      int minIdx = -1;

      // 최솟값 찾기
      for(int j=i; j<len; ++j) {
        if(minVal > arr[j]) {
          minVal = arr[j];
          minIdx = j;
        }
      }

      // 자리 바꾸기
      int temp = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = temp;
    }
  }
}
