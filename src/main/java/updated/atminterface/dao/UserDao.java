package updated.atminterface.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import updated.atminterface.models.User;
import updated.atminterface.util.DBUtil;

public class UserDao {
    
    public User getUserById(String userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM users WHERE userId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("userId"));
                user.setPin(rs.getString("pin"));
                user.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(stmt);
            DBUtil.closeConnection(conn);
        }
        
        return user;
    }

    public boolean withdraw(String userId, double amount) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE users SET balance = balance - ? WHERE userId = ? AND balance >= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.setDouble(3, amount);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(stmt);
            DBUtil.closeConnection(conn);
        }
        
        return success;
    }

    public boolean deposit(String userId, double amount) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE users SET balance = balance + ? WHERE userId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(stmt);
            DBUtil.closeConnection(conn);
        }
        
        return success;
    }

    public boolean transfer(String userId, String recipientId, double amount) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            
            String withdrawSql = "UPDATE users SET balance = balance - ? WHERE userId = ? AND balance >= ?";
            stmt = conn.prepareStatement(withdrawSql);
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.setDouble(3, amount);
            int withdrawRows = stmt.executeUpdate();
            
            if (withdrawRows > 0) {
                String depositSql = "UPDATE users SET balance = balance + ? WHERE userId = ?";
                stmt = conn.prepareStatement(depositSql);
                stmt.setDouble(1, amount);
                stmt.setString(2, recipientId);
                int depositRows = stmt.executeUpdate();
                
                if (depositRows > 0) {
                    conn.commit();
                    success = true;
                } else {
                    conn.rollback();
                }
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.closePreparedStatement(stmt);
            DBUtil.closeConnection(conn);
        }
        
        return success;
    }
}
