package servlets;

import accountServer.AccountServer;
import accountServer.AccountServerImpl;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Maxon on 06.06.2017.
 */
public class AdminPageServletTest {
    private AccountServer accountServer = mock(AccountServerImpl.class);

    private HttpServletResponse getMockedResponse(StringWriter stringWriter) throws IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);

        final PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        return response;
    }

    private HttpServletRequest getMockedRequest(String url) {
        HttpSession httpSession = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getSession()).thenReturn(httpSession);
        when(request.getPathInfo()).thenReturn(url);

        return request;
    }

    @Test
    public void doGet() throws Exception {
        final StringWriter stringWriter = new StringWriter();
        HttpServletResponse response = getMockedResponse(stringWriter);
        HttpServletRequest request = getMockedRequest(AdminPageServlet.PAGE_URL);

        AdminPageServlet adminPageServlet = new AdminPageServlet(accountServer);
        adminPageServlet.doGet(request,response);

        assertEquals("10", stringWriter.toString().trim());
    }

}