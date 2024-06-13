package bankexample;

import java.util.*;
public class BankService {
  private static List<BankAccount> bankAccountList = new ArrayList<>();
  public static void main(String[] args) {
//    BankAccount b1 = new BankAccount("1234-1234");
//    b1.deposit(5000);
//    b1.withdraw(20000);
//
//    BankAccount b2 = new BankAccount("4321");
//    b2.deposit(50000);
//
//    b2.transfer(b1, 3000); // 계좌의 메모리 주소를 던짐
//
//    System.out.println(b2.getBalance());
//    System.out.println(b1.getBalance());

    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println("어떤 서비스를 이용하시겠어요?");
      int cmd = sc.nextInt();

      String accountNumber;
      long amount;
      BankAccount bankAccount;
      String fromNumber, toNumber;
      BankAccount fromAccount, toAccount;
      switch(cmd) {
        case 1:
          System.out.print("계좌 개설 서비스입니다.\n계좌 번호를 입력하세요. :");
          accountNumber = sc.next();
          bankAccountList.add(new BankAccount(accountNumber));
          System.out.println("계좌가 개설 되었습니다.");
          break;
        case 2:
          System.out.println("입금 서비스입니다.");
          System.out.print("계좌번호를 입력하세요.: ");
          accountNumber = sc.next();
          bankAccount = findBankAccount(accountNumber);
          if(bankAccount == null) {
            System.out.println("[Error]: 계좌가 존재하지 않습니다.");
          } else {
            System.out.print("금액을 입력하세요.: ");
            amount = sc.nextLong();
            bankAccount.deposit(amount);
          }
          break;
        case 3:
          System.out.println("출금 서비스입니다.");
          System.out.print("계좌번호를 입력하세요.: ");
          accountNumber = sc.next();
          bankAccount = findBankAccount(accountNumber);
          if(bankAccount == null) {
            System.out.println("[Error]: 계좌가 존재하지 않습니다.");
          } else {
            System.out.print("금액을 입력하세요.: ");
            amount = sc.nextLong();
            bankAccount.withdraw(amount);
          }
          break;
        case 4:
          System.out.println("송금 서비스입니다.");
          System.out.print("출금 계좌번호를 입력하세요.: ");
          fromNumber = sc.next();
          fromAccount = findBankAccount(fromNumber);
          if(fromAccount == null) {
            System.out.println("[Error]: 계좌가 존재하지 않습니다.");
            break;
          }

          System.out.print("입금 계좌번호를 입력하세요.: ");
          toNumber = sc.next();
          toAccount = findBankAccount(toNumber);
          if(toAccount == null) {
            System.out.println("[Error]: 계좌가 존재하지 않습니다.");
            break;
          }

          System.out.print("금액을 입력하세요.: ");
          amount = sc.nextLong();
          fromAccount.transfer(toAccount, amount);
          break;
        case 0:
          System.out.println("종료합니다");
          System.exit(0);
      }
    }
  }

  private static BankAccount findBankAccount(String accountNumber) {
    for(BankAccount b : bankAccountList) {
      if(accountNumber.equals(b.getAccountNumber())) return b;
    }

    return null;
  }

}
