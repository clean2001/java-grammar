package C04Interface.BankService;

public interface BankService {
  void deposit(int amount, BankAccount bankAccount);

  void withdraw(int amount, BankAccount bankAccount);

}
