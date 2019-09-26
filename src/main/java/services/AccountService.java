package services;

import exceptions.DBException;
import models.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.DBRepository;
import utils.Paths;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.SQLException;

public class AccountService {

    private static Logger logger = LogManager.getLogger(AccountService.class);

    DBRepository dbRepository;

    public AccountService(DBRepository dbRepository){
        this.dbRepository = dbRepository;
    }

    @POST
    @Path(Paths.CREATE_ACCOUNT)
    public Account addAccount(Account account) throws DBException, SQLException {
        final String accountId = dbRepository.add(account);
        return dbRepository.get(accountId);

    }

}
