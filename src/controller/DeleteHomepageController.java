package controller;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HomepageDAO;
import model.Homepage;

@WebServlet("/DeleteHomepageController")
public class DeleteHomepageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomepageDAO dao; 
    
    public DeleteHomepageController() {
        super();
        dao = new HomepageDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
        int vID= Integer.parseInt(request.getParameter("vID"));
        dao.deleteHomepage(vID);
        
        action = "listHomepage.jsp";
        request.setAttribute("homepage", HomepageDAO.getAllHomepage());
        }
        RequestDispatcher view = request.getRequestDispatcher("view-homepage.jsp");
        view.forward(request, response);
    }
}