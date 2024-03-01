package tonilearnsjava;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name){
        this.name = name;
        transactions = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public void creditTransaction(Double amount){
        transactions.add(amount);
    }

    public void debitTransaction(Double amount){
        amount *= -1;
        transactions.add(amount);
    }

    public ArrayList<Double> getTransaction(){
        return transactions;
    }
}
