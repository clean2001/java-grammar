package bankexample;

public class BankAccount {
  private String accountNumber;
  private long balance;

  public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  //== Getter Start ==//
  public String getAccountNumber() {
    return accountNumber;
  }

  public long getBalance() {
    return balance;
  }
  //== Getter End ==//


  //== Custom Methods Start ==//
  public void deposit(long amount) {
    this.balance += amount;
    System.out.println(amount + "원 입금되었습니다. / 잔액: " + this.balance + "원");
  }

  public boolean withdraw(long amount) {
    if(this.balance < amount) {
      System.out.println("잔액이 부족합니다. / 잔액: " + this.balance + "원");
      return false;
    }

    this.balance -= amount;
    System.out.println(amount + "원 출금 되었습니다. / 잔액: " + this.balance + "원");
    return true;

  }

  public void transfer(BankAccount b, long amount) {
    if(this.balance < amount) {
      System.out.println("잔액이 부족합니다. / 잔액: " + this.balance + "원");
      return;
    }

    this.balance -= amount;
    b.deposit(amount);
    System.out.println(b.getAccountNumber() + " 계좌로 " + amount + "원 송금 되었습니다. / 잔액: " + this.balance + "원");
  }
  //== Custom Methods End ==//



}
