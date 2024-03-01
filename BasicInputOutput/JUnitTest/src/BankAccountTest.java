import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setup(){
        this.account = new BankAccount("Toni", "Stark", 20000);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        var balance = account.deposit(10000, true);
        assertEquals(30000,balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test has not yet been implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(10000, true);
        assertEquals(30000,account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(10000, true);
        assertEquals(10000,account.getBalance(), 0);
    }
}