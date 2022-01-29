package que2;

import java.sql.*;

import bookApp.model.perisitance.ConnectionFactory;

public class BatchProcessingJDBC {
	
	public static void main(String[] args) {
		
		Connection connection=ConnectionFactory.getConnection();
		
		long start= System.currentTimeMillis();
		
		
			try {
				for(int i=1;i<=1000;i++)
				{
					String s="test "+i;
				PreparedStatement pstmt=connection.prepareStatement("insert into batch(name) values(?)");
				pstmt.setString(1, s);	
				pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		
		
		
		long end= System.currentTimeMillis();
		
		System.out.println("Time taken without using batch processing: "+ (end-start) +"ms");
		
		
		
		long start1= System.currentTimeMillis();
		
		try {
			
			connection.setAutoCommit(false);
			for(int i=1;i<=1000;i++)
			{
				String s="test "+i;
				PreparedStatement pstmt=connection.prepareStatement("insert into batch(name) values(?)");
				pstmt.setString(1, s);
				
				//pstmt.executeUpdate();
				
				pstmt.addBatch();
				
				if(i%250==0)
				{
					pstmt.executeBatch();
				}
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		
		long end1= System.currentTimeMillis();
		
		System.out.println("Time taken using batch processing: "+ (end1-start1) +"ms");
	}
}