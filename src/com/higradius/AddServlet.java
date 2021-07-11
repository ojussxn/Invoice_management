package com.higradius;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet(urlPatterns= {"/AddServlet"},name="AddServlet")
public class AddServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();  
        res.setContentType("text/html");  
        try 
        {  
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    		
    		String mysqlUrl = "jdbc:mysql://localhost:3306/h2h";
    		Connection con = DriverManager.getConnection(mysqlUrl, "root", "Ojus_#98");
    		
    		Statement stmt = con.createStatement();
    		
    		ResultSet rs = stmt.executeQuery("SELECT name_customer, cust_number, invoice_id, total_open_amount, due_in_date, clear_date, Notes FROM mytable limit 22");
    		
    		ArrayList<Response> invList = new ArrayList<>();
    		
    		while(rs.next()) {
    			Response invObj= new Response();
    			invObj.setName(rs.getString("name_customer"));
    			invObj.setNumb(rs.getString("cust_number"));
    			invObj.setId(rs.getFloat("invoice_id"));
    			invObj.setAmt(rs.getFloat("total_open_amount"));
    			invObj.setDate(rs.getString("due_in_date"));
    			invObj.setPdate(rs.getString("clear_date"));
    			invObj.setNotes(rs.getString("Notes"));
    			invList.add(invObj);
    			}
    		Gson gson=new GsonBuilder().setPrettyPrinting().create();
    		String json=gson.toJson(invList);
    		out.println(json); 
            con.close();
    		for (Response obj : invList) {
    			System.out.print("Name: " + obj.getName());
        		System.out.print(", Number: " + obj.getNumb());
        		System.out.print(", ID: " + obj.getId());
        		System.out.print(", Amount: " + obj.getAmt());
        		System.out.print(", Due Date: " + obj.getDate());
        		System.out.print(", Predicted Date: " + obj.getPdate());
        		System.out.print(", Notes: " + obj.getNotes());
        		System.out.println();
    		}

        }
            catch (Exception e) 
            {  
             out.println("error");  
            }
	}
}
