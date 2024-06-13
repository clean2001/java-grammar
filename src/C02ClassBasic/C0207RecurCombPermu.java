package C02ClassBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C0207RecurCombPermu {
  private static List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
  private static boolean[] vis = new boolean[4];
  public static void main(String[] args) {

    // myList로 만들 수 있는 2개짜리 숫자조합을 이중 리스트에 담기

    // 2중 포문 이용
    List<List<Integer>> comb1 = new ArrayList<>();
    for(int i=0; i<myList.size(); ++i) {
      int a = myList.get(i);
      for(int j=i+1; j<myList.size(); ++j) {
        int b = myList.get(j);
        comb1.add(new ArrayList<>(Arrays.asList(a, b)));
      }
    }

    System.out.println("== 이중 포문을 이용한 콤비네이션 ==");
    for(List<Integer> cur : comb1) {
      System.out.println(cur);
    }

    System.out.println("\n== 재귀 ==");
    combination(0, 2, new ArrayList<>(), myList);


    System.out.println("\n== 재귀2 ==");
    List<List<Integer>> comb2 = new ArrayList<>();
    combination2(0, 2, new ArrayList<>(), comb2);
    System.out.println(comb2);

    System.out.println("\n== 순열 ==");
    List<List<Integer>> ans = new ArrayList<>();
    permutation(0, 3, new ArrayList<>(), ans);
    System.out.println(ans);
  }

  private static void combination(int depth, int limit, ArrayList<Integer> ret, List<Integer> pool) {
    if(depth == pool.size()) {
      if(ret.size() == limit) {
        System.out.println(ret);
      }
      return;
    }

    ret.add(pool.get(depth));
    combination(depth+1, limit, ret, pool);
    ret.remove(ret.size()-1);
    combination(depth+1, limit, ret, pool);
  }


  // 수업에서 한 combination
  private static void combination2(int depth, int limit, ArrayList<Integer> ret, List<List<Integer>> answer) {
      if(ret.size() == limit) {
        // temp 값을 그대로 add할 경우 temp 메모리값이 add 되므로, 모든 answer 리스트에 같은 temp 리스트가 add
        answer.add(new ArrayList<>(ret));
        return;
      }


    for(int i=depth; i<myList.size(); ++i) {
      ret.add(myList.get(i));
      combination2(i+1, limit, ret, answer); // 이 부분에 combination2가 그대로 들어온다고 생각하기
      ret.remove(ret.size()-1);
    }

  }

  // 백트래킹 문제 많이 풀어보기!
  private static void permutation(int depth, int limit, ArrayList<Integer> ret, List<List<Integer>> ans) {
    if(ret.size() == limit) {
      ans.add(new ArrayList<>(ret));
      return;
    }

    for(int i=0; i<myList.size(); ++i) {
      if(vis[i]) continue;
      vis[i] = true;
      ret.add(myList.get(i));
      permutation(depth+1, limit, ret, ans);
      vis[i] = false;
      ret.remove(ret.size()-1);
    }
  }
}
