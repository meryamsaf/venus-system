package controller;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CustomerDAO;
import model.Customer;

@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO dao; 
    
    public DeleteCustomerController() {
        super();
        dao = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	
        if (action.equalsIgnoreCase("delete")){
        int custID= Integer.parseInt(request.getParameter("custID"));
        dao.deleteCustomer(custID);
        
        request.setAttribute("customer", CustomerDAO.getAllCustomer());
        }
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}