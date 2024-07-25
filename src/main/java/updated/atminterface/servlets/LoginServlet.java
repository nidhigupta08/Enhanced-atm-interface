package updated.atminterface.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import updated.atminterface.util.DBUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String pin = request.getParameter("pin");

        // Validate user credentials
        boolean isValidUser = validateUser(userId, pin);

        if (isValidUser) {
            // If valid, set session attributes and forward to main menu
            request.getSession().setAttribute("userId", userId);
            request.setAttribute("message", "Login successful.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mainMenu.jsp");
            dispatcher.forward(request, response); // Forward to the JSP for main menu
        } else {
            // If invalid, redirect back to login page with error message
            request.setAttribute("error", "Invalid credentials. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean validateUser(String userId, String pin) {
        String sql = "SELECT * FROM users WHERE user_id = ? AND pin = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, pin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
