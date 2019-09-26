package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private String accountId;
    private String userName;
    private BigDecimal balance;
    private String currency;

    public Account(){}

    public Account(String userName, BigDecimal balance, String currency) {
        this.userName = userName;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public Account setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Account setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Account setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                userName.equals(account.userName) &&
                balance.equals(account.balance) &&
                currency.equals(account.currency);
    }

    @Override
    public int hashCode() {
        int result = getAccountId().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getCurrency().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
