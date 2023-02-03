import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServletTest {
	
	@Test
	public void testDoGet() throws Exception{
		LoginServlet loginservlet = new LoginServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/edit");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		loginservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
	}

	@Test
	  public void testDoPost() throws Exception {
	    // Create mock objects for the request and response
	    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
	    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

	    // Set up the request parameters
	    // with incorrect user and password
	    Mockito.when(request.getParameter("username")).thenReturn("test_user");
	    Mockito.when(request.getParameter("password")).thenReturn("test_password");
	    
	    HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

	    // Call the doPost method of the servlet under test
	    LoginServlet loginservlet = new LoginServlet();
	    loginservlet.doPost(request, response);
	    
	    // Verify the response status code and redirect URL
	    Mockito.verify(response).setStatus(HttpServletResponse.SC_OK);
	    Mockito.verify(response).sendRedirect("HomeServlet");
	  }
	
	@Test
	  public void testDoPostSuccess() throws Exception {
	    // Create mock objects for the request and response
	    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
	    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

	    // Set up the request parameters
	    // with correct user and password
	    Mockito.when(request.getParameter("username")).thenReturn("billy");
	    Mockito.when(request.getParameter("password")).thenReturn("123");
	    
	    HttpSession session = mock(HttpSession.class);
	    when(request.getSession()).thenReturn(session);

	    // Call the doPost method of the servlet under test
	    LoginServlet loginservlet = new LoginServlet();
	    loginservlet.doPost(request, response);
	    
	    verify(response).sendRedirect("HomeServlet");
        verify(session).setAttribute("user", "billy");
        verify(session).setAttribute("userId", 1);
        verify(session).setAttribute("email", "billy@gmail.com");
	  }
	
}
