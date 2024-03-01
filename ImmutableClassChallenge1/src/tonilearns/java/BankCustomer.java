package tonilearns.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private final String name;
    private static int lastCustomerId = 10_000_000;
    private final int id;
    private final List<BankAccount> accounts = new ArrayList<>();
    private int customerId;

     BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        customerId = lastCustomerId++;
        this.id = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.Type.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.Type.SAVINGS, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public BankAccount getAccount(BankAccount.Type type){
         for(var account : accounts){
             if(account.getType() == type){
                 return account;
             }
         }
         return null;
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(this.accounts);
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId,
                String.join("\n\t", accountStrings));
    }
}
