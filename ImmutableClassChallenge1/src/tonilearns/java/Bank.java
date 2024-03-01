package tonilearns.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final  int routingNumber;
    private long lastTransactionId = 1000;
    private Map<String,BankCustomer> customers;


    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }


    public BankCustomer getCustomer(String id){
        BankCustomer customer = customers.get(id);
        return customer;
    }
    public void addCustomer(String name, double checkingInitialDeposit,
                            double savingsInitialDeposit){
        var newCustomer = new BankCustomer(name,checkingInitialDeposit,savingsInitialDeposit);
        customers.put(newCustomer.getCustomerId(),newCustomer);
    }
    public boolean doTransaction(String id, BankAccount.Type accountType, double amount){
        var customer = customers.get(id);
        if(customer  == null) return false;
        BankAccount account  = customer.getAccount(accountType);
        account.commitTransaction(routingNumber,lastTransactionId++,
                customer.getCustomerId(),amount);
        return true;
    }
}
