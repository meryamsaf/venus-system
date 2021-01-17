package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import dao.CustomerDAO;
import model.Customer;

@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private CustomerDAO dao;
	
	public UpdateCustomerController() {
	    super();
	    dao = new CustomerDAO();
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int custID = Integer.parseInt(request.getParameter("custID"));
        Customer sup2 = dao.getCustomerById(custID);
        request.setAttribute("customer", sup2);
        System.out.println(sup2.getCustID());
        RequestDispatcher view = request.getRequestDispatcher("customer-profile.jsp");
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer sup = new Customer();
        int custID=Integer.parseInt(request.getParameter("custID"));
        String cName =request.getParameter("cName");
        String cNum=request.getParameter("cNum");
        String cEmail=request.getParameter("cEmail");
        String cPassword=request.getParameter("cPassword");
        
        sup.setCustID(custID);
        sup.setcName(cName);
        sup.setcNum(cNum);
        sup.setcEmail(cEmail);
        sup.setcPassword(cPassword);
        
        dao.updateCustomer(sup);//DAO
        
        
        request.setAttribute("customer", CustomerDAO.getAllCustomer());
        RequestDispatcher view = request.getRequestDispatcher("dashboard-customer.jsp");
        view.forward(request, response);
    }

}