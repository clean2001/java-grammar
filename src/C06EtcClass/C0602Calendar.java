package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import javax.crypto.spec.PSource;

public class C0602Calendar {
  public static void main(String[] args) {
    // java.util 패키지의 Calendar 클래스
    Calendar calendar = Calendar.getInstance();
    // Tue Jun 18 10:18:57 KST 2024
    // KST: 한국시간
    // UTC: 세계표준시간. 전산 시스템은 대부분 UTC를 기준으로 설계 돼있다.
    System.out.println(calendar.getTime());

    System.out.println(calendar.get(Calendar.YEAR));
    System.out.println(calendar.get(Calendar.MONTH)); // Month가 0부터 시작함
    System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println(calendar.get(Calendar.MINUTE));
    System.out.println(calendar.get(Calendar.SECOND));


    //== java.time 패키지: Local~ 클래스 ==//
    // 날짜(LocalDate) -> date 타입, 시간(LocalTime), 날짜와 시간(LocalDateTime) -> mariaDB의 datetime
    // 시간은 실무적으로 중요하다.
    LocalDate presentDate = LocalDate.now();
    System.out.println();
    System.out.println(presentDate); // 2024-06-18
    System.out.println(presentDate.getYear());
    System.out.println(presentDate.getMonth());
    System.out.println(presentDate.getDayOfMonth());
    System.out.println(presentDate.getDayOfWeek());

    //== LocalTime ==//
    LocalTime presentTime = LocalTime.now();
    System.out.println(presentTime);
    System.out.println(presentTime.getHour());
    System.out.println(presentTime.getMinute());
    System.out.println(presentTime.getSecond());

    // 임의로 특정시간을 만들어내고 싶을 때: of 메소드
    LocalDate birthday = LocalDate.of(2001, 3, 5);
    System.out.println(birthday.getYear());
    System.out.println(birthday.getMonth());
    System.out.println(birthday.getDayOfMonth());

    LocalTime birthTime = LocalTime.of(8, 5, 30);

    LocalDateTime birthdayTime = LocalDateTime.of(2001, 3, 5, 8, 5, 30);
    // 매개 변수로 [크로노필드 enum type]을 사용하여, 프로그램의 유연성을 향상시킬 수 있다.
    System.out.println("----------------------------------------");
    // ChronoField를 쓰는 이유: 유연성 향상. 메소드의 매개변수로 ChronoField를 넘겨줄 수 있음
    myWatch(LocalDateTime.now(), ChronoField.AMPM_OF_DAY);
    System.out.println(birthdayTime.get(ChronoField.YEAR));

    // 0: 오전, 1: 오후
    System.out.println(birthdayTime.get(ChronoField.AMPM_OF_DAY));

  }

  static void myWatch(LocalDateTime localDateTime, ChronoField cf) {
    System.out.println(localDateTime.get(cf));

    if(cf == ChronoField.YEAR) {
      System.out.println("연도는 " + localDateTime.get(cf) + "년입니다.");
    } else if(cf == ChronoField.MONTH_OF_YEAR) {
      System.out.println("월은 " + localDateTime.get(cf) + "월입니다.");
    } else if(cf == ChronoField.AMPM_OF_DAY && localDateTime.get(cf) == 0) {
      System.out.println("오전입니다.");
    } else if(cf == ChronoField.AMPM_OF_DAY && localDateTime.get(cf) == 1) {
      System.out.println("오후입니다.");
    }
  }

}
