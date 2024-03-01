package tonilearns.java;

import dto.Transaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    enum Type{SAVINGS,CHECKING};
    private final Type type;
    private double balance;
    private final Map<Long, Transaction> transactions = new HashMap<>();

    public double getBalance() {
        return balance;
    }
    public Type getType() {
        return type;
    }
    public Map<Long, String> getTransactions() {
        Map<Long,String> txMap = new LinkedHashMap<>();
        for(var tx : transactions.entrySet()){
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    public void commitTransaction(int routingNumber, long transactionId, String customerId, double amount){
       this.balance = (this.balance + amount) <= 0 ? 0 : this.balance + amount;
        var transaction = new Transaction(routingNumber, Integer.parseInt(customerId),(int)transactionId,amount);
        this.transactions.put(transactionId,transaction);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "type=" + type +
                ", balance=" + balance +
                '}';
    }
}
