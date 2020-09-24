import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DashboardServlet", urlPatterns = "/servletDashboard")
public class DashboardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("DashboardServletPOST");

        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("books");

        for (Book book: books) {
            out.println("<h4>"+book.toString()+"</>");

        }
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("DashboardServletGET");

        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("books");

        for (Book book: books) {
            out.println("<h4>"+book.toString()+"</>");
        }
        out.close();
    }
}


