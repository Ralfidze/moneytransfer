package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {

    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;

    public Transaction(String fromAccount, String toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public Transaction setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public String getToAccount() {
        return toAccount;
    }

    public Transaction setToAccount(String toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Transaction setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return fromAccount.equals(that.fromAccount) &&
                toAccount.equals(that.toAccount) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        int result = getFromAccount().hashCode();
        result = 31 * result + getToAccount().hashCode();
        result = 31 * result + getAmount().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}
