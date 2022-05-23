package com.servlet;


import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.dbconnection;

/**
 * Servlet implementation class AddInvoice
 */
@WebServlet("/add")
public class AddInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			 String business_code=request.getParameter("business_code");
			 String cust_number=request.getParameter("cust_number");
			 int customerID=Integer.parseInt(cust_number);  
			 String clear_date = request.getParameter("clear_date");
			 String buisness_year = request.getParameter("buisness_year");
			 String doc_id = request.getParameter("doc_id");
			 String posting_date = request.getParameter("posting_date");
			 String document_create_date = request.getParameter("document_create_date");
			 String due_in_date = request.getParameter("due_in_date");
			 String invoice_currency = request.getParameter("invoice_currency");
			 String document_type = request.getParameter("document_type");
			 String posting_id = request.getParameter("posting_id");
			 int postingID=Integer.parseInt(posting_id);  
			 String total_open_amount = request.getParameter("total_open_amount");
			 int totalAmount=Integer.parseInt(total_open_amount); 
			 String baseline_create_date = request.getParameter("baseline_create_date");
			 String cust_payment_terms = request.getParameter("cust_payment_terms");
			 String invoice_id = request.getParameter("invoice_id");
			 int invoiceID=Integer.parseInt(invoice_id); 

			 Connection con =dbconnection.createConnect();
			 
			 String query="INSERT INTO winter_internship (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date, due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 PreparedStatement st= con.prepareStatement(query);
			 
			 st.setString(1, business_code);
			 st.setInt(2, customerID);
			 st.setString(3, clear_date);
			 st.setString(4, buisness_year);
			 st.setString(5, doc_id);
			 st.setString(6, posting_date);
			 st.setString(7, document_create_date);
			 st.setString(8, due_in_date);
			 st.setString(9, invoice_currency);
			 st.setString(10, document_type);
			 st.setInt(11, postingID);
			 st.setInt(12, totalAmount);
			 st.setString(13, baseline_create_date);
			 st.setString(14, cust_payment_terms);
			 st.setInt(15, invoiceID);		 
			 System.out.println(st);
			 st.executeUpdate();
			
			 con.close();
			 
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}


