package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.descriptionDAO;
import dao.forumDAO;
import model.Description;
import model.Forum;
/**
 * Servlet implementation class addDescriptionCustomerController
 */
@WebServlet("/addDescriptionCustomerController")
public class addDescriptionCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private descriptionDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDescriptionCustomerController() {
        super();
        dao = new descriptionDAO();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int descid = Integer.parseInt(request.getParameter("descid"));

        Description des = dao.getDescriptionById(descid); 
        request.setAttribute("description", des);
        RequestDispatcher view = request.getRequestDispatcher("customer-forum.jsp");
        view.forward(request, response);
	}

   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Description desc = new Description();
	
	
	desc.setDescname(request.getParameter("descname"));
	
	String date = request.getParameter("descdate");
	Date newDate;
	try {
	newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
	desc.setDescdate(newDate);
	} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	desc.setForumID(Integer.parseInt(request.getParameter("forumID")));
	desc.setStaffID(request.getParameter("staffID"));
	desc.setCustID(Integer.parseInt(request.getParameter("custID")));
	
	dao.addDescription(desc);
	
	try {
		request.setAttribute("description", descriptionDAO.getAllDescription());
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	RequestDispatcher dispatcher = request.getRequestDispatcher("customer-forum.jsp");
	dispatcher.forward(request, response);

}

}
