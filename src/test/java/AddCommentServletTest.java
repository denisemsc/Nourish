import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AddCommentServletTest {

	@Mock
	  HttpServletRequest request;

	  @Mock
	  HttpServletResponse response;

	  @Mock
	  HttpSession session;

	  @Mock
	  RequestDispatcher requestDispatcher;

	  @BeforeEach
	  public void setup() {
	    MockitoAnnotations.initMocks(this);
	  }
	  
	  @Test
	  public void doPostTest() throws Exception {
	    StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);

	    when(request.getParameter("review")).thenReturn("This is a test review");
	    when(request.getSession()).thenReturn(session);
	    when(session.getAttribute("userId")).thenReturn(1);
	    when(session.getAttribute("recipeId")).thenReturn(1);
	    when(response.getWriter()).thenReturn(printWriter);

	    AddCommentServlet servlet = new AddCommentServlet();
	    servlet.doPost(request, response);

	    verify(request).getParameter("review");
	    verify(request).getSession();
	    verify(session).getAttribute("userId");
	    verify(session).getAttribute("recipeId");
	    verify(response).setContentType("text/html");
	    verify(response).getWriter();

	    // You could add more asserts here to check if the output of the response is as expected
	  }
	
}
