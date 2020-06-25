package servlets;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C17calcularSalarioPageImport extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        float salbase, grat, desc, salbruto, salliquido;
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        PrintWriter out;
        resp.setContentType("text/html");
        out = resp.getWriter();
        salbase =
        Float.parseFloat(req.getParameter("salbase").replace(',', '.'));
        grat = Float.parseFloat(req.getParameter("grat").replace(',', '.'));
        desc = Float.parseFloat(req.getParameter("desc").replace(',', '.'));
        salbruto = salbase + salbase * (grat / 100);
        salliquido = salbruto - salbruto * (desc / 100);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Salário</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Folha de pagamento</h2>");
        out.println("<p>Salário líquido: " + df.format(salliquido) + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}