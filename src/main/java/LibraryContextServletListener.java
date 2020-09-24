import model.Book;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class LibraryContextServletListener implements ServletContextListener {

    private ArrayList<Book> books;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    books = new ArrayList();

    books.add(new Book("Tytul1","Autor1",2001));
    books.add(new Book("Tytul2","Autor2",2002));
    books.add(new Book("Tytul3","Autor3",2003));

    servletContextEvent.getServletContext().setAttribute("books",books);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
