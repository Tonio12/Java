package tonilearnsjava;

public class Main {
    public static void main(String[] args) {
        Bank  newBank = new Bank("28Bank");
        Customer customer = new Customer("Antonio");
        customer.creditTransaction(900.0);
        customer.debitTransaction(100.0);
        customer.creditTransaction(177.0);

        newBank.addCustomer(customer);
        newBank.printStatement(customer);

    }
}
