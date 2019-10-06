package repository.implementation;
import exceptions.DBException;
import models.Account;
import models.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import repository.DBRepository;
import utils.H2SQLConstants;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class H2DBRepository implements DBRepository {

    private static Logger logger = LogManager.getLogger(H2DBRepository.class);

    private final Connection connection;

    public H2DBRepository() throws DBException, IOException, SQLException {
        this.connection = getH2Connection();
    }

    private static Connection getH2Connection() throws DBException, IOException, SQLException {

        InputStream input = H2DBRepository.class.getClassLoader()
                .getResourceAsStream("h2.properties");

        Properties properties = new Properties();
        properties.load(input);

        String url = properties.getProperty("url");
        String name = properties.getProperty("username");
        String pass = properties.getProperty("password");

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(url);
        ds.setUser(name);
        ds.setPassword(pass);

        Connection connection = DriverManager.getConnection(url, name, pass);
        return connection;
    }

    @Override
    public String add(Account account) throws SQLException, DBException {
        if (account.getAccountId() != null) {
            return String.format("Can not create account with an existing id: '%s'",
                    account.getAccountId());
        }

        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        try {

            stmt = connection.prepareStatement(H2SQLConstants.CREATE_ACCOUNT);
            stmt.setString(1, account.getUserName());
            stmt.setBigDecimal(2, account.getBalance());
            stmt.setString(3, account.getCurrency());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                logger.error("Creating account failed ....");
                throw new DBException("Failed on creating account!");
            }
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getString(1);
            } else {
                logger.error("Creating account failed ....");
                throw new DBException("Failed on creating account!");
            }
        } catch (SQLException | DBException e) {
            logger.error("Error Inserting Account  " + account);
            throw new DBException("Error creating user account " + account, e);
        } finally {
            generatedKeys.close();
            stmt.close();
            connection.close();
        }

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(String accountId) {

    }

    @Override
    public void transferMoney(Transaction parameters) {

    }

    @Override
    public Account get(String accountId) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    public void insertData() throws SQLException {
        logger.info("Insert data  from sql file ");

        try {
            File f = new File("data.sql");
            f.exists();
            RunScript.execute(connection, new FileReader(String.valueOf(H2DBRepository.class.getClassLoader()
                    .getResource("data.sql").getPath())));
        } catch (SQLException e) {
            logger.error("Error inserting data: ", e);
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            logger.error("Error inserting data:", e);
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
