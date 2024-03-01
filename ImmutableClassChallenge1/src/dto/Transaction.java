package dto;

public class Transaction {
    private int routingNumber;
    private int customerId;
    private int transactionId;
    private double transactionAmount;

    public Transaction(int routingNumber, int customerId, int transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber, customerId,
                transactionId, transactionAmount);
    }
}
