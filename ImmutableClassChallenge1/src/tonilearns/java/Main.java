package tonilearns.java;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(326564);
        bank.addCustomer("Joe",500,5000);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if(bank.doTransaction(joe.getCustomerId(),BankAccount.Type.CHECKING,-600)){
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(BankAccount.Type.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k,v)-> System.out.println(k + ": " + v));
    }
}
