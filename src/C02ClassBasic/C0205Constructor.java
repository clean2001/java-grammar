package C02ClassBasic;

public class C0205Constructor {
  public static void main(String[] args) {
//    Calendar calendar = new Calendar();

//    System.out.println(calendar.getYear() + "년 " + calendar.getMonth() + "월 " + calendar.getDay() + "일입니다.");

  }
}

class Calendar {
  private String year;
  private String month;
  private String day;

  public Calendar(String year, String month, String day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  // 같은 클래스 내의 다른 생성자 호출시 this() 사용
  public Calendar(String year, String month) {
    this(year, month, null);
  }

  public Calendar() {
  }

  public String getYear() {
    return year;
  }

  public String getMonth() {
    return month;
  }

  public String getDay() {
    return day;
  }

}
