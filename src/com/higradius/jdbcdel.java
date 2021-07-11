package com.higradius;
import java.sql.*;

public class jdbcdel{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/h2h";
		
	static final String USER = "root";
	static final String PASS = "Ojus_#98";
	
	public static void main(String[] args) throws Exception{
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	
	    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    	
	    	stmt = conn.createStatement();
	    	String sql;
	    	sql = "DELETE name_customer, cust_number, invoice_id, total_open_amount, due_in_date FROM mytable where total_open_amount=32098.79";
	    	rs = stmt.executeQuery(sql);
	    	
	    	while(rs.next()){
	    		
	    		String name = rs.getString("name_customer");
	    		String numb = rs.getString("cust_number");
	    		float id = rs.getFloat("invoice_id");
	    		float amt = rs.getFloat("total_open_amount");
	    		String date = rs.getString("due_in_date");

	    		System.out.print("Name: " + name);
	    		System.out.print(", Number: " + numb);
	    		System.out.print(", ID: " + id);
	    		System.out.println(", Amount: " + amt);
	    		System.out.println(", Due Date: " + date);
	    		System.out.println();
	    		}
	    	rs.close();
	    	stmt.close();
	    	conn.close();
	    }
	    catch(SQLException se)
	    {
	    	se.printStackTrace();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try{
	    		if(stmt!=null)
	    		stmt.close();
	    		}
	    	catch(SQLException se2){
	    	}
	    	try
	    	{
	    		if(conn!=null)
	    		conn.close();
	    	}
	    	catch(SQLException se)
	    	{
	    		se.printStackTrace();
	    	}
	    }
	    }
	}