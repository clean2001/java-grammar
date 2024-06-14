package C04Interface.BankService;


public class BankCardService implements BankService {
  @Override
  public void deposit(int money, BankAccount bankAccount) {
    int balance = bankAccount.getBalance();
    int total = balance + money;
    bankAccount.updateBalance(total);
    System.out.println(money + "원 카드로 입금되었습니다.");
    System.out.println("현재 잔액은 " + total);
  }

  @Override
  public void withdraw(int money, BankAccount bankAccount){
    int balance = bankAccount.getBalance();
    int total;
    if(balance < money){
      System.out.println("잔액 부족입니다.");
    }else {
      total = balance - money;
      bankAccount.updateBalance(total);
      System.out.println(money + "원 카드로 출금되었습니다.");
    }
    System.out.println("현재 잔액은 " + bankAccount.getBalance());
  }
}