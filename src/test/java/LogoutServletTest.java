import static org.mockito.Mockito.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutServletTest {
  private HttpServletRequest request;
  private HttpServletResponse response;
  private LogoutServlet logoutServlet;

  @BeforeEach
  public void setUp() {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    logoutServlet = new LogoutServlet();
  }

  @AfterEach
  public void tearDown() {
    request = null;
    response = null;
    logoutServlet = null;
  }

  @Test
  public void testDoGet() throws Exception {
    HttpSession session = mock(HttpSession.class);
    when(request.getSession()).thenReturn(session);
    logoutServlet.doGet(request, response);
    verify(session).invalidate();
    verify(response).sendRedirect("login.jsp");
  }
}