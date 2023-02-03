import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DeleteCommentServletTest {

	@Mock
	  HttpServletRequest request;

	  @Mock
	  HttpServletResponse response;

	  @Mock
	  HttpSession session;

	  @BeforeEach
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	  }
	  
	  @Test
	    public void testDoGet() throws ServletException, IOException {
	        DeleteCommentServlet servlet = new DeleteCommentServlet();
	        when(request.getParameter("id")).thenReturn("1");
	        when(request.getSession()).thenReturn(session);
	        when(session.getAttribute("recipeId")).thenReturn(1);
	        
	        // verify that the comment has been deleted from the database
	        // verify that the response redirects to the correct page
	        }
	  
	  

}
