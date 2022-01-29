package transaction;

import java.sql.*;

import bookApp.model.perisitance.ConnectionFactory;

public class TransactionAccount {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			PreparedStatement pstmt = connection.prepareStatement("update account set balance=balance-1000 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("update account set balance=balance+1000 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();
			connection.commit();
			System.out.println("Transaction completed");

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}