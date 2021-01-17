package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.bookingDAO;
import dao.CustomerDAO;
import model.Booking;
import model.Customer;



import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * Servlet implementation class updateBookingController
 */
@WebServlet("/RateBookingController")
public class RateBookingController extends HttpServlet {
	
	private bookingDAO dao;
    public RateBookingController() {
    	dao = new bookingDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        Booking book = dao.getBookingById(bookingID); 
        request.setAttribute("booking", book);
        RequestDispatcher view = request.getRequestDispatcher("customer-rate.jsp");
        view.forward(request, response);
	}
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Booking sup = new Booking();
        sup.setBookingID(Integer.parseInt(request.getParameter("bookingID")));
        sup.setRating(Integer.parseInt(request.getParameter("rating")));
        dao.updateBooking1(sup); //dalam dao
        
        try {
			request.setAttribute("booking", bookingDAO.getAllBooking());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher view = request.getRequestDispatcher("viewBooking.jsp");
        view.forward(request, response);
    }
}