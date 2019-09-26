package repository;

import exceptions.DBException;
import models.Account;
import models.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface DBRepository {

        String add(Account account) throws SQLException, DBException;
        void update(Account account);
        void delete(String accountId);
        void transferMoney(Transaction parameters);

        Account get(String accountId);
        List<Account> getAll();
    }
