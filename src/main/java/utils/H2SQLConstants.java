package utils;

public class H2SQLConstants {
    public final static String GET_ACCOUNT_BY_ID = "SELECT * FROM ACCOUNT WHERE AccountId = ? ";
    public final static String LOCK_ACCOUNT_BY_ID = "SELECT * FROM ACCOUNT WHERE AccountId = ? FOR UPDATE";
    public final static String CREATE_ACCOUNT = "INSERT INTO ACCOUNT (UserName, Balance, CurrencyCode) VALUES (?, ?, ?)";
    public final static String UPDATE_ACCOUNT_BALANCE = "UPDATE ACCOUNT SET Balance = ? WHERE AccountId = ? ";
    public final static String GET_ALL_ACCOUNT = "SELECT * FROM ACCOUNT";
    public final static String DELETE_ACCOUNT_BY_ID = "DELETE FROM ACCOUNT WHERE AccountId = ?";
}
