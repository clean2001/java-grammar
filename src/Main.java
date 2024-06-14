import java.io.*;
import java.util.*;

class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int cnt = 0;
    int num = 665;
    while(true) {
      num++;
      String s = Integer.toString(num);
      if(s.contains("666")) {
        cnt++;
      }
      if(cnt == N) break;
    }

    System.out.println(num);
  }
}