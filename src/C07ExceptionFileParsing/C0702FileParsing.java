package C07ExceptionFileParsing;

// 파일의 형식 (이 수업에서는 2가지 정도만!)
// 1. txt 파일 형식
// 2. json 형식: 문자열로 이뤄진 특수한 형식(키:밸류)


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

// io 패키지와 nio 패키지가 있음
// 수업에서는 nio 패키지 위주로 할 것임.
// nio 패키지는 일반적으로 성능이 좋다고 알려져있지만, 스레드 언세잎 이슈가 있다.
// io 패키지는 일반적으로 성능이 좋지 않지만 스레드 세잎
public class C0702FileParsing {
  public static void main(String[] args) throws IOException {
    //== 콘솔에서 읽기 ==//
    // io 패키지 사용
//    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//    String input = br1.readLine(); // 한줄 읽기
//    System.out.println(input);

    //== 파일에서 읽기 ==//
    BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test_file.txt"));
    String line;
    while((line = br2.readLine()) != null) {
      System.out.println(line);
    }
  }

}
