package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import dao.HomepageDAO;
import model.Homepage;

@WebServlet("/UpdateHomepageController")
public class UpdateHomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private HomepageDAO dao;
	
	public UpdateHomepageController() {
	    super();
	    dao = new HomepageDAO();
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vID = Integer.parseInt(request.getParameter("vID"));
        Homepage sup2 = dao.getHomepageById(vID);
        request.setAttribute("homepage", sup2);
        System.out.println(sup2.getvID());
        RequestDispatcher view = request.getRequestDispatcher("update-homepage.jsp");
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Homepage sup = new Homepage();
        int vID=Integer.parseInt(request.getParameter("vID"));
        String vName =request.getParameter("vName");
        String vLocation=request.getParameter("vLocation");
        String vPhone=request.getParameter("vPhone");
        String vDetails=request.getParameter("vDetails");
        String staffID=request.getParameter("staffID");
        
        sup.setvName(vName);
        sup.setvLocation(vLocation);
        sup.setvPhone(vPhone);
        sup.setvDetails(vDetails);
        sup.setStaffID(staffID);
        
        dao.updateHomepage(sup);//DAO
        
        
        request.setAttribute("homepage", HomepageDAO.getAllHomepage());
        RequestDispatcher view = request.getRequestDispatcher("view-homepage.jsp");
        view.forward(request, response);
    }

}