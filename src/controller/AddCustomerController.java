package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import dao.CustomerDAO;
import model.Customer;


@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO dao;
    
    public AddCustomerController() {
        super();
        dao = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int custID = Integer.parseInt(request.getParameter("custID"));//no function
        
        RequestDispatcher view = request.getRequestDispatcher("addCustomer.jsp");
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve input and set values
    	int custID;
    	
    	try {
			Customer sup = new Customer();

			//retrieve and set email and password
			sup.setcName(request.getParameter("cName"));
	        sup.setcNum(request.getParameter("cNum"));
	        sup.setcEmail(request.getParameter("cEmail"));
	        sup.setcPassword(request.getParameter("cPassword"));
	        custID = dao.insertAndGetID(sup);

	        System.out.print(custID);
        
	        HttpSession session = request.getSession(true);

			session.setAttribute("custID", custID);
	        Customer sup2 = dao.getCustomerById(custID);
	        request.setAttribute("cust", sup2);
	        System.out.println(sup2.getCustID());
	        RequestDispatcher view = request.getRequestDispatcher("customer-profile.jsp");
	        view.forward(request, response);
			
    		}catch (Throwable ex) {
			System.out.println(ex);
			}
    	
    	
    		
        /*Customer sup = new Customer();
		
        sup.setcName(request.getParameter("cName"));
        sup.setcNum(request.getParameter("cNum"));
        sup.setcEmail(request.getParameter("cEmail"));
        sup.setcPassword(request.getParameter("cPassword"));
        //invoke addCustomer method in CustomerDAO
        dao.addCustomer(sup);

        request.setAttribute("customer", CustomerDAO.getAllCustomer());
        RequestDispatcher view = request.getRequestDispatcher("listCustomer.jsp");
        view.forward(request, response);*/
    	
        }

}