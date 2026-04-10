package ebook581;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;


public class EmployeeDAO {

		static Connection getDBConnection() {

		Connection connection = null;


		try {

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/24wh1a0581","root","1234");

	       


		} catch (SQLException e) {

			e.printStackTrace();


		}

		return connection;

	}


	List<Employee> getEmployees(){


		List<Employee> employeeList = new ArrayList<>();

		Connection connection = EmployeeDAO.getDBConnection();

		try {


			Statement statement=connection.createStatement();

			ResultSet rs=statement.executeQuery("select * from Employee");


			while(rs.next()) {

				Employee employee=new Employee(rs.getInt("empid"), rs.getString("name"), rs.getInt("salary"), rs.getString("department"));

				employeeList.add(employee);

			}

			connection.close();


		} catch (SQLException e) {

			e.printStackTrace();

		}

		return employeeList;

	}

}





