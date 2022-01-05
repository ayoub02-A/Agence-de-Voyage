package dao;

import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import dao.SingletonConnection;

public class Testdao {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		//System.out.println(new java.sql.Date(System.currentTimeMillis()));
		
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(new java.sql.Date(System.currentTimeMillis()));
		System.out.println(s);
		
		
		  
		
		
		
	}
	
}
