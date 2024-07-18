package updated.atminterface.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import updated.atminterface.models.Transaction;
import updated.atminterface.util.DBUtil;

public class TransactionDao {
    
    public List<Transaction> getTransactionsByUserId(String userId) {
    	List<Transaction> transactions = new ArrayList<Transaction>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM transactions WHERE userId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transactionId"));
                transaction.setUserId(rs.getString("userId"));
                transaction.setType(rs.getString("type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getTimestamp("date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(stmt);
            DBUtil.closeConnection(conn);
        }
        
        return transactions;
    }
    
    // Add other methods as needed
}
