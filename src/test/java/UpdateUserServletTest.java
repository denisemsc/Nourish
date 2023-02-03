import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UpdateUserServletTest extends Mockito {

  @Test
  public void testDoPost() throws Exception {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpSession session = mock(HttpSession.class);

    when(request.getParameter("username")).thenReturn("testuser");
    when(request.getParameter("email")).thenReturn("testuser@gmail.com");
    when(request.getSession()).thenReturn(session);
    when(session.getAttribute("userId")).thenReturn(1);
    when(session.getAttribute("user")).thenReturn("testuser");
    when(session.getAttribute("email")).thenReturn("testuser@gmail.com");

    UpdateUserServlet servlet = new UpdateUserServlet();
    servlet.doPost(request, response);

    verify(session).setAttribute("user", "testuser");
    verify(session).setAttribute("email", "testuser@gmail.com");
    verify(response).sendRedirect("UserServlet");
  }
}