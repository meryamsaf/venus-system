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

@WebServlet("/ListCustomerController")
public class ListCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private CustomerDAO dao;
	
	public ListCustomerController() {
	    super();
	    dao = new CustomerDAO();
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int custID = Integer.parseInt(request.getParameter("custID"));
        Customer sup2 = dao.getCustomerById(custID);
        request.setAttribute("cust", sup2);
        System.out.println(sup2.getCustID());
        RequestDispatcher view = request.getRequestDispatcher("customer-profile.jsp");
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	int custID = Integer.parseInt(request.getParameter("custID"));
        Customer sup2 = dao.getCustomerById(custID);
        request.setAttribute("customer", sup2);
        
        RequestDispatcher view = request.getRequestDispatcher("customer-update.jsp");
        view.forward(request, response);
    	
    	
    	
    	/*Customer sup = new Customer();
        sup.setCustID(Integer.parseInt(request.getParameter("custID")));
        sup.setcName(request.getParameter("cName"));
        sup.setcNum(request.getParameter("cNum"));
        sup.setcEmail(request.getParameter("cEmail"));
        sup.setcPassword(request.getParameter("cPassword"));
        System.out.print(sup);
       // dao.updateCustomer(sup);//DAO
        
        request.setAttribute("customer", CustomerDAO.getAllCustomer());
        RequestDispatcher view = request.getRequestDispatcher("customer-update.jsp");
        view.forward(request, response);*/
    }

}