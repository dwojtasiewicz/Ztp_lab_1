import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "AdminServlet", urlPatterns = "/servletAdmin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Welcome ADMIN");

        out.println("<form action=\"ServletADDBook\" method=\"POST\">");
        out.println("Tytul : <input type=\"text\" name=\"name\"<br/><br/>");
        out.println("Autor : <input type=\"text\" name=\"author\"<br/><br/>");
        out.println("Rok : <input type=\"int\" name=\"year\"<br/><br/>");
        out.println("<input type=\"submit\" value=\"Add\">");
        out.println("</form>");


        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("books");

        for (Book book: books) {

            out.println("<h4>" + book.toString() + "</h4>");

            out.println("<form action=\"BookServletDelete\" method=\"POST\">");
            out.println("<input type=\"hidden\" name=\"name\" value="+book.getName()+">");
            out.println("<input type=\"submit\" value=\"Delete\">");
            out.println("</form>");

        }
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
