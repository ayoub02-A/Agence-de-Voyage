package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.SingletonConnection;
import metier.Administrateur;

public class LoginAdminDao {

	public boolean login(Administrateur a) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from administrateur where email_admin = ? and mdp_admin = ? "); 
            String mdp =  getMd5(a.getMdp_admin());
            preparedStatement.setString(1,a.getEmail_admin());
            preparedStatement.setString(2,mdp);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	System.out.println("email Rs : " + rs.getString("email_admin"));
            	status = true;
            }
           
        } 
         catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		return status;
	}
	
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	
	public String getMd5(String input){
		try {
			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//  of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());
			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);
			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} 
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
}
