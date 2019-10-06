import exceptions.DBException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import repository.DBRepository;
import repository.implementation.H2DBRepository;
import services.AccountService;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);
    private static final int PORT = 5000;
    public static void main(String[] args) throws DBException, SQLException, IOException {
        logger.info("Starting service...");
        H2DBRepository database = new H2DBRepository();
        database.insertData();
        logger.info("Completed");

        new Application().startService();
    }

    private void startService() throws IOException, SQLException, DBException {

        Server server = new Server(8083);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/*");
        server.setHandler(context);
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitParameter("jersey.config.server.provider.classnames",
                        AccountService.class.getCanonicalName());

        try {
            server.start();
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }


    }
}
