package com.higradius;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class createList {
	public static void main(String args[]) throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		String mysqlUrl = "jdbc:mysql://localhost:3306/h2h";
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "Ojus_#98");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from mytable limit 22");
		
		ArrayList<Response> invList = new ArrayList<>();
		
		while(rs.next()) {
			Response invObj= new Response();
			invObj.setName(rs.getString("name_customer"));
			invObj.setNumb(rs.getString("cust_number"));
			invObj.setId(rs.getFloat("invoice_id"));
			invObj.setAmt(rs.getFloat("total_open_amount"));
			invObj.setDate(rs.getString("due_in_date"));
			invList.add(invObj);
			}
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String json=gson.toJson(invList);
		System.out.println(json);
		
		for (Response obj : invList) {
			System.out.print("Name: " + obj.getName());
    		System.out.print(", Number: " + obj.getNumb());
    		System.out.print(", ID: " + obj.getId());
    		System.out.print(", Amount: " + obj.getAmt());
    		System.out.print(", Due Date: " + obj.getDate());
    		System.out.println();
		}
		
		
	}
}
