package bugbash;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("serial")
@Component(service = { Servlet.class })
@SlingServletResourceTypes(resourceTypes = "/hello")
public class HelloWorldServlet extends SlingSafeMethodsServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getOutputStream().println("<html><body>");
        res.setContentType("text/html");
        res.getOutputStream().println("<p>Hello World</p>");
        res.getOutputStream().println("</body></html>");
    }
}
