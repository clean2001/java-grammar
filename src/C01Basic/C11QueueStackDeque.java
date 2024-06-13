package C01Basic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueueStackDeque {

  public static void main(String[] args) {
//    Queue<Integer> myQueue = new LinkedList<>();
//    myQueue.add(10);
//    myQueue.add(20);
//    myQueue.add(30);
//    System.out.println(myQueue.peek()); // 10. 맨위의 값을 조회만 함
//    System.out.println(myQueue.poll()); // 10. 맨위의 값을 꺼냄
//    System.out.println(myQueue);

    //== Queue가 왜 내부적으로 LinkedList인지 ==> 시간복잡도와 관련해서 대답하면 좋을 듯 ==//

    // List : 동적배열

    // 참고: 검색과 인덱스를 통한 접근은 다른 이야기이다.

    //== LinkedList는 삽입/삭제 성능이 높다. (중간 삽입과 중간 삭제) ==//

    // Queue에는 get() 메소드가 구현돼있지 않다.
    // LinkedList에는 get()이 비효율적이지만 구현돼있다. (List도 상속 받고 있기 때문에)
    // LinkedList

    // LinkedList와 ArrayList 비교

    final int MAX_COUNT = 10000;

    // LinkedList
    LinkedList<Integer> linkedlist = new LinkedList<>();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < MAX_COUNT; ++i) {
      linkedlist.add(0, 10);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("linkedlist의 중간 삽입: " + (endTime - startTime));

    // ArrayList
    ArrayList<Integer> arraylist = new ArrayList<>();
    long startTime2 = System.currentTimeMillis();
    for (int i = 0; i < MAX_COUNT; ++i) {
      arraylist.add(0, 10);
    }
    long endTime2 = System.currentTimeMillis();
    System.out.println("arraylist의 중간 삽입: " + (endTime2 - startTime2));

    // 조회 테스트
    // LinkedList
    LinkedList<Integer> linkedlist2 = new LinkedList<>();
    long startTime3 = System.currentTimeMillis();
    for (int i = 0; i < MAX_COUNT; ++i) {
      linkedlist.get(i);
    }
    long endTime3 = System.currentTimeMillis();
    System.out.println("linkedlist의 조회: " + (endTime3 - startTime3));

    // ArrayList
    long startTime4 = System.currentTimeMillis();
    for (int i = 0; i < MAX_COUNT; ++i) {
      arraylist.get(i);
    }
    long endTime4 = System.currentTimeMillis();
    System.out.println("arraylist의 조회: " + (endTime4 - startTime4));

    //== 큐 사용 예제 ==//
    // 큐: 선입 선출
    // 스택: 후입 선출

    Queue<String> myQueue = new LinkedList<>();
    myQueue.add("문서1");
    myQueue.add("문서2");
    myQueue.add("문서3");
    myQueue.add("문서4");
    while (!myQueue.isEmpty()) {
      System.out.println(myQueue.poll());
    }

    // ArrayBlockingQueue: 길이 제한 큐
    Queue<String> abq = new ArrayBlockingQueue<>(3);

    // add를 사용하면 길이 제한 초과시 예외 발생
    abq.add("10");
    abq.add("20");
    abq.add("30");
//    abq.add("40");
//    abq.add("50");
    System.out.println(abq);

    // offer를 쓰면 예외 발생하지 않음
    abq.offer("10");
    abq.offer("20");
    System.out.println(abq);

    // 우선순위 큐: 데이터를 꺼낼 때 정렬된 데이터 pop
    // PriorityQueue의 괄호 안에는 Comparator가 들어간다. (아무것도 없으면 오름차순)
    // PriorityQueue: 전체 정렬이 아님. 요소를 꺼내는 시점에 가장 작인 값만 꺼내오는 것이다.
    Queue<Integer> pq = new PriorityQueue<>();
    pq.add(50);
    pq.add(30);
    pq.add(10);
    pq.add(20);
    pq.add(40);
    pq.add(50);

    System.out.println(pq);

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }

    // pq는 하나를 꺼낼때마다 logn이다. 다 꺼내면 NlogN ->

    // pq를 쓰는 경우 => 안에 들어있는 데이터가 **동적으로 바뀔때** priorityQueue를 쓴다.

    //== Stack ==//
    Stack<Integer> st = new Stack<>();

    st.push(10);
    st.push(20);
    st.push(30);

    System.out.println(st.pop()); // 10
    System.out.println(st.peek()); // 20

    // String 객체 5개 정도 Stack 추가 후에 while문을 통해 출력
    Stack<String> st2 = new Stack<>();
    st2.add("1");
    st2.add("2");
    st2.add("3");
    st2.add("4");
    st2.add("5");

    while (!st2.isEmpty()) {
      System.out.println(st2.pop());
    }

    //== 같은 숫자는 싫어 ==//
    int[] arr = {1, 1, 3, 3, 0, 1, 1};
    Stack<Integer> stack = new Stack<>();
    for (int a : arr) {
      if (stack.isEmpty()) {
        stack.push(a);
      } else {
        if (stack.peek() != a) {
          stack.push(a);
        }

      }
    }
    System.out.println(stack);
    for(int a : stack) {
      System.out.println(a);
    }

    //== Deque ==//

    Deque<Integer> dq = new ArrayDeque<>();
    dq.addLast(10);
    dq.addLast(20);
    System.out.println(dq);
    dq.addFirst(30);
    System.out.println(dq);

    System.out.println(dq.peekLast());
    System.out.println(dq.peekFirst());
    System.out.println(dq.poll()); // pollFirst()와 같다.
    System.out.println(dq.pop()); // pollLast()와 같다.

    //== 다리를 지나는 트럭 ==//
  }
}
