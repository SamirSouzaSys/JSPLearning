package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C01ServletsHello extends HttpServlet {
    public void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws ServletException, IOException {
                
        PrintWriter out;
        resposta.setContentType("text/html");
        out = resposta.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>JSP - Hello, World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Primeira página com Servlet</h2>");
        out.println("<p>Hello, world!</p>");
        out.println("</body>");
        out.println("</html>");
    }
}