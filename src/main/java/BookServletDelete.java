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

@WebServlet(name = "BookServletDelete")
public class BookServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("name");


        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("books");

        int iter=0;
        for (Book book: books)
        {
            if (book.getName().equals(n))
            {
                books.remove(iter);
                break;
            }
            iter++;
        }
        request.getServletContext().setAttribute("books",books);

        RequestDispatcher rd=request.getRequestDispatcher("servletAdmin");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
