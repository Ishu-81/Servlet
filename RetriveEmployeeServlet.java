package ebook581;


import java.io.IOException;

import java.io.PrintWriter;

import java.util.List;


import com.google.gson.Gson;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


@WebServlet("/getEmployees")   

public class RetriveEmployeeServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

	        throws ServletException, IOException {


	    resp.setContentType("application/json");

	    PrintWriter out = resp.getWriter();


	    EmployeeDAO empDAO = new EmployeeDAO();

	    List<Employee> empList = empDAO.getEmployees();


	    Gson gson = new Gson();

	    String json = gson.toJson(empList); 


	    out.print(json);

	}

}






