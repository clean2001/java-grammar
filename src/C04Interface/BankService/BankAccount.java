package C04Interface.BankService;

// 작업의 대상이 되는 개체 즉, Entity
public class BankAccount{
  static long static_id =0L;
  private long id;
  private String accountNumber;
  private int balance;
  BankAccount(String accountNumber){
    static_id +=1 ;
    id = static_id;
    this.accountNumber = accountNumber;
  }
  public String getAccountNumber() {
    return accountNumber;
  }
  public int getBalance() {
    return balance;
  }

  public Long getId() {
    return id;
  }


  public void updateBalance(int balance) {
    this.balance = balance;
  }
}