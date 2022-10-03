package com.codeo.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FirstServletDao {

	public void submitData(String name, String lastname, String email, String mobileno, String gender, String subject) {
	//persistent logic JDBC logic(Insertion operation)
	//Roll_no, firstname, lastname, gender, email, phone number, subject, entry_time	
		try {
			//Register JDBC Driver  for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			Connection con=null;
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","");
			System.out.println(con);
			 //create PreparedStatement object
			String query="insert into student_details( firstname, lastname, gender, email, mobileno, subject) values(?,?,?,?,?,?)";
			System.out.println(query);
			PreparedStatement preparedstatement=null;
			if(con!=null) {
				preparedstatement=con.prepareStatement(query);
			   System.out.println(preparedstatement);
			}
			//prepare the query
			//age calculation using dob
			
			
			
			int result=0;
			//send and execute the query 
			if(preparedstatement!=null) {
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, lastname);
				preparedstatement.setString(3, gender);
				preparedstatement.setString(4, email);
				preparedstatement.setString(5, mobileno);
				preparedstatement.setString(6, subject);
			}
			if(preparedstatement!=null) {
				result=preparedstatement.executeUpdate();
			 
			}
			
			//process the result
			if(result!=0) {
				System.out.println("Data inserted successfully");
				
			   
			}
			else {
				System.out.println("Data is not inserted");
		
			  
			}
			preparedstatement.close();
			con.close();
			 }
			 catch(ClassNotFoundException e) {
				 e.printStackTrace();
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		
	}

}
