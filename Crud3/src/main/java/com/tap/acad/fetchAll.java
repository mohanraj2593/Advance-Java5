package com.tap.acad;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tap.acad.model.employee;

public class fetchAll extends HttpServlet {
	HttpSession session;
	ArrayList<employee> empList = new ArrayList<employee>();
	String fetchAll="select * from employee";
	Connection con;
	Statement stmt;
	ResultSet result;
	PrintWriter pw;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee","root","mohanraj@123");
		} catch (Exception  e) {
			
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			 pw=res.getWriter();
			 stmt=con.createStatement();
				 result=stmt.executeQuery(fetchAll);
				 empList.clear();
				while(result.next()) {
					empList.add(new employee(result.getInt("empid"),
							result.getString("empname"),
							result.getString("desig"),
							result.getInt("salary"),
							result.getString("email"),
							result.getString("password")
							));
					
				}
				 session=req.getSession();
				 session.setAttribute("empList", empList);
				 res.sendRedirect("showEmployee.jsp");

//				while(result.next()) {
//					pw.println(result.getInt("empid")+"   "
//							+result.getString("empname")+"   "
//							+result.getString("desig")+"   "
//							+result.getInt("salary")+"   "
//							+result.getString("email")+"   "
//							+result.getString("password")
//							);
//					
//				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
