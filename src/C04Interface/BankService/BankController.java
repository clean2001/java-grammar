package C04Interface.BankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankController {
  private static final BankService bcs = new BankCardService();
  private static final BankService bks = new BankKakaoService();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("계좌번호를 입력하세요");
    String accountNumber = sc.nextLine();
    BankAccount bankAccount = new BankAccount(accountNumber);

    loop1:
    while (true) {
      System.out.println("서비스 번호를 입력하세요. 1.카드 / 2. 카카오페이 / 3. 종료");
      int number1 = Integer.parseInt(sc.nextLine());

      if(number1 == 3) {
        System.out.println("종료합니다.");
        break loop1;
      }

      System.out.println("입금하시려면 1번, 출금하시려면 2번");
      int number2 = Integer.parseInt(sc.nextLine());

      if (number1 == 1) { // 카드
        if(number2 == 1) { // 입금
          System.out.println("카드 입금 서비스입니다.");
          System.out.println("입금하실 금액을 적어주세요.");
          int amount = Integer.parseInt(sc.nextLine());
          bcs.deposit(amount, bankAccount);
        } else if(number2 == 2) { // 출금
          System.out.println("카드 출금 서비스입니다.");
          System.out.println("출금하실 금액을 적어주세요.");
          int amount = Integer.parseInt(sc.nextLine());
          bcs.withdraw(amount, bankAccount);
        }
      } else if(number1 == 2) { // 카카오페이
        if(number2 == 1) { // 입금
          System.out.println("카카오페이 입금 서비스입니다.");
          System.out.println("입금하실 금액을 적어주세요.");
          int amount = Integer.parseInt(sc.nextLine());
          bks.deposit(amount, bankAccount);
        } else if(number2 == 2) { // 출금
          System.out.println("카카오페이 출금 서비스입니다.");
          System.out.println("출금하실 금액을 적어주세요.");
          int amount = Integer.parseInt(sc.nextLine());
          bks.withdraw(amount, bankAccount);
        }
      } else {
        System.out.println("[Error] 잘못된 입력입니다.");
      }
    }
  }

}