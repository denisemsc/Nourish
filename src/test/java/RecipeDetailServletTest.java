import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dvops.maven.eclipse.Comment;
import com.dvops.maven.eclipse.Recipe;

class RecipeDetailServletTest {
	
	@Test
	public void testDoGet() throws ServletException, IOException {
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    HttpSession session = mock(HttpSession.class);
	    Recipe recipe = new Recipe(1, "recipeName", "ingredients", "image", "wRecipe", "vRecipe");
	    List<Recipe> recipeList = new ArrayList<>();
	    recipeList.add(recipe);
	    Comment comment = new Comment(1, 1, "recipeName", 1, "username", "review", "dateposted");
	    List<Comment> commentList = new ArrayList<>();
	    commentList.add(comment);
	    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

	    when(request.getSession()).thenReturn(session);
	    when(request.getParameter("id")).thenReturn("1");
	    when(request.getRequestDispatcher("recipeDetail.jsp")).thenReturn(requestDispatcher);

	    RecipeDetailServlet recipedetailServlet = new RecipeDetailServlet();
	    

	}

}
