package com.higradius;
import java.sql.*;

public class jdbc{
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
	    	sql = "SELECT name_customer, cust_number, invoice_id, total_open_amount, due_in_date,clear_date,Notes FROM mytable limit 11";
	    	rs = stmt.executeQuery(sql);
	    	
	    	while(rs.next()){
	    		
	    		String name = rs.getString("name_customer");
	    		String numb = rs.getString("cust_number");
	    		float id = rs.getFloat("invoice_id");
	    		float amt = rs.getFloat("total_open_amount");
	    		String date = rs.getString("due_in_date");
	    		String pdate = rs.getString("clear_date");
	    		String notes = rs.getString("Notes");

	    		System.out.print("Name: " + name);
	    		System.out.print(", Number: " + numb);
	    		System.out.print(", ID: " + id);
	    		System.out.print(", Amount: " + amt);
	    		System.out.print(", Due Date: " + date);
	    		System.out.print(", Predicted Date: " + pdate);
	    		System.out.print(", Notes: " + notes);
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