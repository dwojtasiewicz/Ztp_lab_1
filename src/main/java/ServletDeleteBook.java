import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ServletDeleteBook")
public class ServletDeleteBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("aaaaaaaaaaaaaaaaaa");

        String n=request.getParameter("name");
        String a=request.getParameter("author");
        int y= Integer.parseInt(request.getParameter("year"));
        out.println(n);

        Book dodaj= new Book(n,a,y);

        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("books");

        books.add(dodaj);

        request.getServletContext().setAttribute("books",books);

        RequestDispatcher rd=request.getRequestDispatcher("servletAdmin");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
