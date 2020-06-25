package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C16exibirTabuadaRequestWhile extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int num, i = 1;
        PrintWriter out;
        
        resp.setContentType("text/html");
        
        out = resp.getWriter();
        num = Integer.parseInt(req.getParameter("num"));
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tabuada</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Tabuada do " + num + "</h2>");
        
        while (i <= 10)
        {
            out.println(num + " x " + i + " = " + num * i + "<br>");
            i++;
        }
        out.println("</body>");
        out.println("</html>");
    }
}