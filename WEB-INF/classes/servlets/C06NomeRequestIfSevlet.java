package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C06NomeRequestIfSevlet extends HttpServlet {
    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
{
    String nome_completo, pronome;
    char sexo;

    PrintWriter out;
    resp.setContentType("text/html");
    out = resp.getWriter();

    nome_completo = req.getParameter("nome") + " " + req.getParameter("sobre");
    
    if (req.getParameter("sexo") != null)
        sexo = req.getParameter("sexo").charAt(0);
    else
        sexo = ' ';

        if (sexo == 'F')
            pronome = "Sra. ";
        else
        if (sexo == 'M')
            pronome = "Sr. ";
        else
            pronome = "";
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Seu nome</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>Olá, " + pronome + nome_completo + "!</p>");
    out.println("</body>");
    out.println("</html>");
    }
}