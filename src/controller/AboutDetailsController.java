package controller;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.HomepageDAO;
import model.Homepage;

@WebServlet("/AboutDetailsController")
public class AboutDetailsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomepageDAO dao;
    
    public AboutDetailsController() {
        super();
        dao = new HomepageDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // int vID = Integer.parseInt(request.getParameter("vID"));//No Function
        Homepage home = new Homepage();
    	
        request.setAttribute("homepage", HomepageDAO.getHomepageDetails());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}