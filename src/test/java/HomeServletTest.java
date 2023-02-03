import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;

import com.dvops.maven.eclipse.Recipe;

class HomeServletTest {
	
	@Test
	public void testDoGet_Insert() throws Exception {
		// fail("Not yet implemented");
		// mock HttpServletRequest & HttpServletResponse

		HomeServlet homeservlet = new HomeServlet();

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/insert");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		homeservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}

	@Test
	public void testDoGet_Delete() throws Exception {
		
		HomeServlet homeservlet = new HomeServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/delete");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		homeservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}
	
	@Test
	public void testDoGet_Edit() throws Exception {
		
		HomeServlet homeservlet = new HomeServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/edit");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		homeservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}
	
	@Test
	public void testDoGet_Update() throws Exception {
		
		HomeServlet homeservlet = new HomeServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getServletPath()).thenReturn("/update");
		when(response.getWriter()).thenReturn(mock(PrintWriter.class));

		homeservlet.doGet(request, response);

		verify(response.getWriter()).append("Served at: ");
		verify(request).getContextPath();
	}
	
	@Test
	public void doGet_default() throws ServletException, IOException, SQLException {
		HomeServlet homeservlet = new HomeServlet();
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    PrintWriter mockPrintWriter = mock(PrintWriter.class);
	    
	    when(request.getServletPath()).thenReturn("");
	    when(response.getWriter()).thenReturn(mockPrintWriter);
	    
	}
	
	@Test
	public void listRecipes_SQLException() throws SQLException, IOException, ServletException {
	    HomeServlet homeservlet = new HomeServlet();
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    Connection connection = mock(Connection.class);
	    
	    doThrow(new SQLException("Test SQLException")).when(connection).prepareStatement("SELECT * from recipes ");

	    
	}
	
	
	@Test
	public void testListRecipes() throws Exception {
		HomeServlet homeservlet = new HomeServlet();
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);

	    // set expectations for the mock objects
	    when(request.getAttribute("listRecipes")).thenReturn(Arrays.asList(
	        new Recipe(1, "Recipe 1", "Ingredients 1", "Image 1", "wRecipe 1", "vRecipe 1"),
	        new Recipe(2, "Recipe 2", "Ingredients 2", "Image 2", "wRecipe 2", "vRecipe 2")
	    ));
	    when(request.getRequestDispatcher("/index.jsp")).thenReturn(mock(RequestDispatcher.class));

	    // call the method under test
	    homeservlet.listRecipes(request, response);
	}
	
	
	
	


	
	
	
	
	
	

}