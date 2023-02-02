
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.dvops.maven.eclipse.Comment;
import com.dvops.maven.eclipse.Recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class RecipeDetailServlet
 */
@WebServlet("/RecipeDetailServlet")
public class RecipeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/nourish";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int recipeId = Integer.parseInt(request.getParameter("id"));
		// System.out.println(recipeId);
		String query = "select * from recipes where id = " + recipeId;
		String commentQuery = "select * from comments where recipeId = " + recipeId;

		//Get recipes 
		List<Recipe> recipe = new ArrayList<>();
		// TODO Auto-generated method stub
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				session.setAttribute("recipeName", name);
				session.setAttribute("recipeId", id);
				System.out.println("recipeName: " + name);
				System.out.println("recipeId: " + id);

				String ingredients = rs.getString("ingredients");
				String image = rs.getString("image");
				String wRecipe = rs.getString("wRecipe");
				String vRecipe = rs.getString("vRecipe");
				recipe.add(new Recipe(id, name, ingredients, image, wRecipe, vRecipe));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		//Get comments
		List<Comment> comment = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(commentQuery);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				int recipeid = rs.getInt("recipeId");
				int userId = rs.getInt("userId");
				String recipeName = rs.getString("recipeName");
				String username = rs.getString("username");
				String review = rs.getString("review");
				String dateposted = rs.getString("dateposted");
				comment.add(new Comment(id, recipeid, recipeName, userId, username, review, dateposted));
				System.out.println(username + ", " + review + ", " + dateposted);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("listComment", comment);
		request.setAttribute("listRecipe", recipe);
		request.getRequestDispatcher("recipeDetail.jsp").forward(request, response);

	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
