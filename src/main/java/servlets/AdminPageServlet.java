package servlets;

import accountServer.AccountServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxon on 06.06.2017.
 */
public class AdminPageServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(AdminPageServlet.class.getName());
    public static final String PAGE_URL = "/admin";
    private final AccountServer accountServer;

    public AdminPageServlet(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int limit = accountServer.getUsersLimit();
        int count = accountServer.getUsersCount();

        logger.info("Limit: {}. Count {}", limit, count);

        if (limit > count) {
            logger.info("User pass");
            accountServer.addNewUser();
            resp.getWriter().println(accountServer.getUsersLimit());
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            logger.info("User were rejected");
            resp.getWriter().println("Server is closed for maintenance!");
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        //String parameter = req.getParameter("key");
        /*int usersLimit = accountServer.getUsersLimit();
        resp.getWriter().print(usersLimit);
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);*/
    }
}
