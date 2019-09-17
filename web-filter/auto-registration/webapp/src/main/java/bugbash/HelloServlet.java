package bugbash;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getPathInfo().equals("/hello")) {
            resp.getOutputStream().print("Hello!");
        } else if (req.getPathInfo().equals("/exception")) {
            throw new RuntimeException();
        } else {
            super.doGet(req, resp);
        }
    }
}
