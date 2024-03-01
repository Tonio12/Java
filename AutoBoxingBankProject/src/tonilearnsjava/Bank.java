package tonilearnsjava;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;
    private String name;

    public Bank(String name){
        this.name = name;
        customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer newCustomer){
        for(Customer customer: customers){
            if(customer.getName().equals(newCustomer.getName())){
                return false;
            }
        }
        customers.add(newCustomer);
        return true;
    }
    public void printStatement(Customer c){
        for(Customer customer: customers){
            if(customer.getName().equals(c.getName())){
                var transactions = customer.getTransaction();
                System.out.println("Name: " + c.getName());
                System.out.println("Transactions");
                System.out.println("-".repeat(30));
                for(double transaction : transactions){
                    if(transaction < 0){
                        System.out.println("Debit: " + transaction);
                    }else {
                        System.out.println("Credit: " + transaction);
                    }
                }
            }
        }
    }
}
