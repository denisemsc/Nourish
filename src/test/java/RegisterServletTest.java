import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterServletTest {

	@Test
	public void testDoGet() throws Exception{
		RegisterServlet registerservlet = new RegisterServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/edit");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		registerservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
	}
	
	@Test
	public void testSuccessfulRegistration() throws ServletException, IOException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    PrintWriter writer = mock(PrintWriter.class);

	    when(request.getParameter("username")).thenReturn("testuser");
	    when(request.getParameter("password")).thenReturn("testpassword");
	    when(request.getParameter("email")).thenReturn("testuser@email.com");
	    when(response.getWriter()).thenReturn(writer);

	    new RegisterServlet().doPost(request, response);

	    verify(response).sendRedirect("login.jsp");
	    verify(writer).println("You have successfully registered an account!");
	}
	
}
