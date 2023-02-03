import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.dvops.maven.eclipse.User;

class UserServletTest {

	@Test
	public void testDoGet_Insert() throws Exception {
		// fail("Not yet implemented");
		// mock HttpServletRequest & HttpServletResponse

		UserServlet userservlet = new UserServlet();

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/insert");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		userservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}

	@Test
	public void testDoGet_Delete() throws Exception {

		UserServlet userservlet = new UserServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/delete");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		userservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}

	@Test
	public void testDoGet_Edit() throws Exception {

		UserServlet userservlet = new UserServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/edit");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		userservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}

	@Test
	public void testDoGet_Update() throws Exception {

		UserServlet userservlet = new UserServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/update");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		userservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}

	@Test
	public void doGet_default() throws ServletException, IOException, SQLException {
		UserServlet userservlet = new UserServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter mockPrintWriter = mock(PrintWriter.class);

		when(request.getServletPath()).thenReturn("");
		when(response.getWriter()).thenReturn(mockPrintWriter);

		userservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();

		Connection connection = mock(Connection.class);
		doThrow(new SQLException("Test SQLException")).when(connection).prepareStatement("SELECT * from users ");

		try {
			userservlet.listUser(request, response);
			fail("Expected an SQLException to be thrown");
		} catch (SQLException e) {
			assertEquals("Test SQLException", e.getMessage());
		}

	}
	@Test
	public void listUsers_SQLException() throws SQLException, IOException, ServletException {
		UserServlet userservlet = new UserServlet();
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    Connection connection = mock(Connection.class);
	    
	    doThrow(new SQLException("Test SQLException")).when(connection).prepareStatement("SELECT * from users ");

	    try {
	    	userservlet.listUser(request, response);
	        fail("Expected an SQLException to be thrown");
	    } catch (SQLException e) {
	        assertEquals("Test SQLException", e.getMessage());
	    }
	}

	@Test
	void testListUser() throws ServletException, IOException, SQLException {
		// Create mock objects for HttpServletRequest and HttpServletResponse
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

		// Set up the mock HttpSession object with a userId attribute
		HttpSession session = Mockito.mock(HttpSession.class);
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(session.getAttribute("userId")).thenReturn(1);

		// Create an instance of the UserServlet and call the listUser method
		UserServlet servlet = new UserServlet();
		servlet.listUser(request, response);

		// Verify that the user record was retrieved and processed correctly
		// (This would need to be implemented further to actually check the result)
		// ...
	}
}