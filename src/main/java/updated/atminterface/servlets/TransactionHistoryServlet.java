package updated.atminterface.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import updated.atminterface.dao.TransactionDao;
import updated.atminterface.models.Transaction;
import java.util.List;

@WebServlet("/TransactionHistoryServlet")
public class TransactionHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId != null) {
            TransactionDao transactionDao = new TransactionDao();
            List<Transaction> transactions = transactionDao.getTransactionsByUserId(userId);

            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("/WEB-INF/views/transactionHistory.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
