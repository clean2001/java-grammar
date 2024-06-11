import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int[][] arr;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    for(int i=0; i<N; ++i) {
      String line = br.readLine();
      for(int j=0; j<N; ++j) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs());
  }

  private static int bfs() {
    Deque<int[]> dq = new LinkedList<>();
    boolean[][] vis = new boolean[N][N];
    dq.addFirst(new int[] {0, 0, 0}); // y, x, 흰색으로 바꾼 개수
    vis[0][0] = true;

    while(!dq.isEmpty()) {
      int[] cur = dq.pollFirst();
      int y = cur[0];
      int x = cur[1];
      int c = cur[2];

      if(y == N-1 && x == N-1) return c;

      for(int i=0; i<4; ++i) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
        if(vis[ny][nx]) continue;

        vis[ny][nx] = true;

        if(arr[ny][nx] == 0) { // 검은색
          dq.addLast(new int[] {ny, nx, c+1});
        } else { // 흰색
          dq.addFirst(new int[] {ny, nx, c});
        }
      }
    }

    return -1;
  }
}