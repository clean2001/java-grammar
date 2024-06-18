package C05AnonymousLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C0504StreamApi {

  public C0504StreamApi() {
  }

  public static void main(String[] args) {
//    int[] arr = {20, 10, 4, 12};
//
//    // 전통적인 방식의 데이터 접근 방식: 메모리 주소 접근
//    for(int i=0; i<arr.length; ++i) {
//      System.out.println(arr[i]);
//    }
//
//    // 함수형 프로그래밍 방식: 데이터와 객체 중심이 아닌, 입력에 따른 출력만 존재한다.
//    // 핵심: arr의 원본을 쓰는 것이 아닌, arr의 **복제본**을 가져와서 쓰는 것이다.
//    // **원본을 건드리지 않는다!!**
//    // 결론: 데이터의 안정성이 올라간다.
//
//    // 자바에서 함수형 프로그래밍을 지원하기 위한 라이브러리가 streamAPI
//    // forEach: 스트림의 각 요소를 소모하면서 동작을 수행
//    Arrays.stream(arr).forEach(a -> System.out.println(a));

    // 주로 래퍼 클래스, 제네릭에서 문제가 조금 발생.
    // 그래서 다른 언어보다는 활용도가 떨어진다.
    // 구조적 문제점이 존재

//    // 스트림의 생성
//    String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
//    // Stream<클래스명>: 제네릭 타입으로 스트림 객체가 생성된다.
//    Stream<String> stream1 = Arrays.stream(stArr);
//
//    List<String> stList = new ArrayList<>(Arrays.asList(stArr));
//    Stream<String> stream2 = stList.stream();
//
//    //==
//    int[] intArr = {10, 20, 30, 40, 50};
////    Stream<Integer> stream3 = Arrays.stream(intArr); // 이거 바로 안됨
//
//    // 기본형 자료는 별도의 stream을 제공해주고 있다.
//    IntStream stream3 = Arrays.stream(intArr);
//    IntStream stream4 = Arrays.stream(intArr);
//
//    List<Integer> myList = new ArrayList<>();
//    myList.add(10);
//    myList.add(20);
//    myList.add(30);
//
//    Stream<Integer> stream5 = myList.stream();
    // int가 아니라 Integer라서 IntStream 사용불가
//    IntStream stream6 = myList.stream();



    //== stream 변환(중개 연산) ==//

    // **filter**, **map**, sorted, distinct, limit
//    String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
    // filter: 특정 기준을 가지고 대상을 필터링
    // filter() 메소드는 Stream<String>을 반환한다. (필터링이 적용된 새로운 스트림 객체)

    // 제네릭의 타입 소거 문제 발생
    // 제네릭의 타입 소거란 제네릭 타입을 런타임 시점에는 제거하는 것을 의미.
    // 그래서, 타입이 소거된 Stream 객체에서 배열로 변환하려면 타입이 뭔지를 명시해줘야함(타입 캐스팅)

    // 이유 1: 런타임에 제네릭 타입소거 => 스트링 타입이라고 알려줘야한다.
    // 이유 2:

    // 방법 1: a 변수에는 stream 요소의 개수.
//    String[] newStArr = Arrays.stream(stArr).filter(a-> a.length() <= 4).toArray(a -> new String[a]);
//
//    // 이것도 됨
////    String[] newStArr3 = (String[]) Arrays.stream(stArr).filter(a-> a.length() <= 4).toArray();
//
//    // 방법 2: 메소드 참조(매개변수가 추론 가능할 때 생략하는 형식): 클래스::메서드
//
//    String[] newStArr2 = Arrays.stream(stArr).filter(a-> a.length() <= 4).toArray(String[]::new);
//
//    Arrays.stream(stArr).forEach(System.out::println); // 메소드 참조 방식


    int[] intArr = {10, 10, 30, 40, 50};
    // IntStream이라서 제네릭 타입 소거가 되지 않는 것이다!!
    int[] newIntArr = Arrays.stream(intArr).filter(a -> a <= 30).toArray();


    int[] newIntArr2 = Arrays.stream(intArr).distinct().toArray();
    int total = Arrays.stream(intArr).sum();
    System.out.println(Arrays.toString(newIntArr2));
    System.out.println(total);


    //== map ==//
    // map: 기존의 스트림을 조작하여 새로운 스트림 반환
    int[] newMapArr = Arrays.stream(intArr).map(a -> a*10).toArray();
    System.out.println(Arrays.toString(newMapArr));

    // 홀수 찾기 =>
    int[] arr1 = {1, 2, 3, 4, 5, 6};
    // 홀수만 담은 배열 생성
    int[] ret1 = Arrays.stream(arr1).filter(a -> a % 2 == 1).toArray();
    System.out.println("홀수: " + Arrays.toString(ret1));

    // 홀수만 담은 배열의 값을 제곱한 새로운 배열 생성: filter, map;
    int[] ret2 = Arrays.stream(arr1).filter(a -> a % 2 == 1).map(a -> a * a).toArray();
    System.out.println("홀수 제곱: " + Arrays.toString(ret2));

    // 홀수만 담음 배열의 값을 제곱한 새로운 배열 내림차순 정렬
    int[] ret3 = Arrays.stream(arr1).filter(a -> a % 2 == 1).map(a -> a * a).sorted().toArray();
    System.out.println(Arrays.toString(ret3));

    //== mapToInt ==//
    // mapToInt: IntStream 형태로 변환 시켜준다.
    String[] stArr = {"HTML", "CSS", "JAVASCRIPT", "JAVA"};

    // 각 문자열의 길이를 담은 새로운 int 배열
    int[] ret4 = Arrays.stream(stArr).mapToInt(String::length).toArray();
    System.out.println(Arrays.toString(ret4));

    // limit
    int[] ret5 = Arrays.stream(stArr).mapToInt(String::length).limit(3).toArray();
    System.out.println(Arrays.toString(ret5));

    //== 스트림의 소모 ==//
    // 스트림의 소모 -> 스트림: sum 합계, reduce: 누적 연산(누적 합, 곱, 나눗셈 등등), foreEach(주로 출력에서 사용
    //== count(), sum() ==//
    int[] arr = {10, 20, 30, 40};
    Arrays.stream(arr).forEach(System.out::println);

    int intArrSum = Arrays.stream(arr).sum();
    System.out.println(intArrSum);
    // optional 객체: 값이 있을 수도 있고 없을 수도 있음을 명시한 객체
    int minVal = Arrays.stream(arr).min().getAsInt(); // OptionalInt
    int maxVal = Arrays.stream(arr).max().getAsInt();
    int cnt = (int)Arrays.stream(arr).count(); // 반환 타입 long

    //== reduce ==//
    // reduce(초기값, 연산식);
    int allMultiply = Arrays.stream(arr).reduce(1, (a, b) -> a * b);
    int allAdd = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

    System.out.println(allMultiply);
    System.out.println(allAdd);

    String[] sArr = {"hello", "java", "world"};
//    String stAllAdd = Arrays.stream(sArr);

    //== findFirst, findAny ==//
    // findFirst: 첫번째 요소 찾기
    List<Student> students = new ArrayList<>();
    students.add(new Student("kim", 20));
    students.add(new Student("choi", 32));
    students.add(new Student("lee", 35));
    students.add(new Student("park", 22));

    // 나이가 30이 넘는 학생중에 첫번째 인덱스 값을 가지는 학생 객체 생성
    Student s1 = students.stream()
        .filter(s-> s.age > 30).findFirst().get();


    // 1) 모든 객체의 평균 나이를 스트림을 구하기
    // 2) 가장 나이 어린 사람 찾기
    // 3) 30대가 몇명인지 출력

    // 30대의 이름을 String 배열에 담기


    // 1)
    double average = students.stream().mapToInt(s -> s.getAge()).average().getAsDouble();
    System.out.println("평균 나이: " + average);

    // 2)
    Student student = students.stream().sorted((a, b) -> a.getAge() - b.getAge()).findFirst().get();
    Student student2 = students.stream().min((a, b) -> a.getAge() - b.getAge()).get(); // 이것도 됨
    System.out.println("가장 나이 어린 사람: " + student.getName() + " " + student.getAge());

    // 3) 30대가 몇명인지
    long count = students.stream().filter(s -> s.getAge() >= 30).count();
    System.out.println("30대가 몇명? :" + count);

    // 30대의 이름을 String 배열에 담기
    String[] nameArr = students.stream().filter(s -> s.getAge() >= 30).map(Student::getName)
        .toArray(String[]::new); // 메소드 참조

    System.out.println("30대 이름: " + Arrays.toString(nameArr));


    // Stream<객체> => Optional<객체> => get()
    // IntStream => OptionalInt => getAsInt()

    //==  ==//
    // 1. 스트림 생성: 컬렉션, 배열을 대상으로 stream 메서드를 사용해서 스트림 생성

    // 2. 스트림의 중개 연산: filter, map(mapToInt), distinct, sorted, limit => 스트림을 반환

    // 3. 스트림을 소모: reduce(초기값, 연산식), forEach, sum/max/min/count => optional

    // (System::println)
    // new를 사용함으로써 생성자 호출 (생성자도 메소드임)

    //== Optional 객체 ==//
    // Optional 객체: 특정 객체에 값이 없을지도 모른다는 것을 **명시적으로** 표현!!
//    Optional<String> opt1 = Optional.ofNullable(null);
//    String st1 = null;
////    System.out.println(opt1.get()); // NoSuchElementException.
//
//    // ofNullable: null이 있을 수도 있는 경우에 Optional 객체를 생성하는 메서드
//    if(opt1.isPresent()) {
//      System.out.println(opt1.get().compareTo("hello"));
//    } else {
//      System.out.println("값이 없습니다.");
//    }

    //
    Optional<String> opt1 = Optional.empty();
    Optional<String> opt2 = Optional.of("hello"); // null이 못들어감
    Optional<String> opt3 = Optional.ofNullable(null); // null이 들어갈 수 있음

    // 내가 직접 Optional을 만들 일은 거의 없음
    // 중요한 것: return 타입이 Optional 객체인 메서드를 사용했을 때 어떻게 할것인가? => 후속 작업을 어떻게 할 것인가

    //== Optional 객체 처리 방법 (4가지) ==//

    // 방법 1. isPresent()로 있는지 없는지 확인 후 get()

    // 방법 2. orElse(디폴트값): 값이 있으면 그 값을 리턴. 없으면 default 지정값 return

    // 방법 3. orElseGet(()->{}): 값이 있으면 그 값을 리턴, 없으면 람다함수 실행

    // 방법 4. orElseThrow(()-> new 예외("메시지")) => 가장 중요!!!!!!!!. 값이 있으면 그 값을 리턴, 없으면 예외 강제 발생 ==> 프로젝트에서 90% 이거 쓸거임
    // 참고: 예외에서는 코드와 메시지가 가장 중요하다.


    // 방법 1. isPresent => 코드가 약간 번잡해짐
    if(opt3.isPresent()) {
      System.out.println(opt3.get().length());
    }

    // 방법 2. orElse()
    System.out.println(opt2.orElse("").length()); // 5 출력.

    // 방법 3. orElseGet()
    System.out.println(opt3.orElseGet(() -> new String("")).length()); // 깡통 스트링 -> 0 출력

    // ** 방법 4. orElseThrow() => 예외를 적절하게 발생시키면서 적잘한 메시지를 주기
    // 개발할 때 예외를 사용자에게 적절한 메시지 전달 목적으로 강제 발생시키는 경우도 존재.
    // () -> new NoSuchElementException("값이 없습니다.") => 이 부분은 Supplier 의 구현체이다.
    System.out.println(opt3.orElseThrow(() -> new NoSuchElementException("값이 없습니다.")));

    // Optional
    OptionalDouble answer = students.stream().filter(a -> a.getAge() >= 29).mapToInt(a -> a.getAge()).average();
    if(answer.isPresent()) {
      System.out.println(answer.getAsDouble());
    } else {
      System.out.println("값이 없습니다.");
    }

    // orElseThrow
    double answer2 = students.stream()
        .filter(a -> a.getAge() >= 29)
        .mapToInt(Student::getAge)
        .average()
        .orElseThrow(() -> new NoSuchElementException("배열에 값이 없습니다."));
    System.out.println(answer2);


    // 스레드의 전제: 동시에 작업
    Thread t2 = new Thread(() -> System.out.println("새로 생성한 스레드2입니다."));
    t2.start();

  }
}
