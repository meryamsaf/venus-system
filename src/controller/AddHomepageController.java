package controller;
import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dao.StaffDAO;
import dao.HomepageDAO;
import model.Homepage;
import model.Staff;

@WebServlet("/AddHomepageController")
public class AddHomepageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomepageDAO dao;
   
    
    public AddHomepageController() {
        super();
        dao = new HomepageDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int vID = Integer.parseInt(request.getParameter("vID"));//no function
        
        request.setAttribute("staff", StaffDAO.getAllStaff());
        RequestDispatcher view = request.getRequestDispatcher("add-homepage.jsp");
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve input and set values
        Homepage sup = new Homepage();
        
        sup.setvName(request.getParameter("vName"));
        sup.setvLocation(request.getParameter("vLocation"));
        sup.setvPhone(request.getParameter("vPhone"));
        sup.setvDetails(request.getParameter("vDetails"));
        sup.setStaffID(request.getParameter("staffID"));
        //invoke addHomepage method in HomepageDAO
        dao.addHomepage(sup);

        request.setAttribute("homepage", HomepageDAO.getAllHomepage());
        RequestDispatcher view = request.getRequestDispatcher("view-homepage.jsp");
        view.forward(request, response);
        }

}