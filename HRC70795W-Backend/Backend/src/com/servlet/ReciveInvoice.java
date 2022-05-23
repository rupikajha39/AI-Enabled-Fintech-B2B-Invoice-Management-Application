package com.servlet; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.*; 
import java.util.ArrayList; 
 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
//import com.jdbc.dbConnection; 
import com.jdbc.dbconnection; 
import com.pojo.Invoice;/** 
// /* Servlet implementation class ReciveInvoice 
// */ 
@WebServlet("/fetch") 
public class ReciveInvoice extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
        
    /** 
     * @see HttpServlet#HttpServlet() 
     */ 
    public ReciveInvoice() { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
 
 /** 
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
  */ 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
  // TODO Auto-generated method stub 
  try { 
 
   Connection con = dbconnection.createConnect(); 
   Statement st = con.createStatement(); 
   String query = "SELECT sl_no, business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id,aging_bucket from winter_internship ORDER BY sl_no  "; 
   ResultSet rs = st.executeQuery(query); 
    
   ArrayList<Invoice> data = new ArrayList<>(); 
   while(rs.next()) 
   { 
    Invoice inv = new Invoice(); 
      
    inv.setSl_no(rs.getInt("sl_no")); 
    inv.setBusiness_code(rs.getString("business_code")); 
    inv.setCust_number(rs.getInt("cust_number")); 
    inv.setClear_date(rs.getString("clear_date")); 
    inv.setBuisness_year(rs.getString("buisness_year")); 
    inv.setDoc_id(rs.getString("doc_id")); 
    inv.setPosting_date(rs.getString("posting_date")); 
    inv.setDocument_create_date(rs.getString("document_create_date")); 
//    inv.setDocument_create_date1(rs.getString("document_create_date1")); 
    inv.setDue_in_date(rs.getString("due_in_date")); 
    inv.setInvoice_currency(rs.getString("invoice_currency")); 
    inv.setDocument_type(rs.getString("document_type")); 
    inv.setPosting_id(rs.getInt("posting_id")); 
//    inv.setArea_business(rs.getString("area_business")); 
    inv.setTotal_open_amount(rs.getInt("total_open_amount")); 
    inv.setBaseline_create_date(rs.getString("baseline_create_date")); 
    inv.setCust_payment_terms(rs.getString("cust_payment_terms")); 
    inv.setInvoice_id(rs.getInt("invoice_id")); 
//    inv.setIsOpen(rs.getInt("isOpen")); 
//    inv.setAging_bucket(rs.getString("aging_bucket")); 
//    inv.setIs_deleted(rs.getInt("is_deleted")); 
//     
    data.add(inv); 
   } 
   Gson gson = new GsonBuilder().serializeNulls().create(); 
   String invoices  = gson.toJson(data); 
   PrintWriter out=response.getWriter(); 
   out.print(invoices); 
    
   rs.close(); 
   st.close(); 
   con.close(); 
    
  } 
  catch(SQLException e) { 
   e.printStackTrace(); 
  } 
  catch(Exception e) { 
   e.printStackTrace(); 
  } 
 } 
 
 /** 
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
  */ 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
  // TODO Auto-generated method stub 
  doGet(request, response); 
 } 
 
}