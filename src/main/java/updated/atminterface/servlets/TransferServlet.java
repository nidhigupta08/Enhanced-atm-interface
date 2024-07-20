package updated.atminterface.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import updated.atminterface.dao.UserDao;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String recipientId = request.getParameter("recipientId");
        double amount = Double.parseDouble(request.getParameter("amount"));

        if (userId != null) {
            UserDao userDao = new UserDao();
            boolean success = userDao.transfer(userId, recipientId, amount);

            if (success) {
                response.sendRedirect("mainMenu.jsp");
            } else {
                request.setAttribute("error", "Transfer failed. Check recipient ID or balance.");
                request.getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
