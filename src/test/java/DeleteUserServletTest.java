import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteUserServletTest {

	@Test
	  public void testDoGet() throws Exception {
	    DeleteUserServlet servlet = new DeleteUserServlet();
	    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
	    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
	    HttpSession session = Mockito.mock(HttpSession.class);
	    Mockito.when(request.getSession()).thenReturn(session);
	    Mockito.when(request.getContextPath()).thenReturn("contextPath");
	    
	  }

}
