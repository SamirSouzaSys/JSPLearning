package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C15contarletrasrequestswitchLetras extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String nome;
        int vogais = 0, consoantes = 0, brancos = 0;
        PrintWriter out;
        resp.setContentType("text/html");
        out = resp.getWriter();
        nome = req.getParameter("nome").toUpperCase();
        for (int i=0; i < nome.length(); i++)
        {
            switch (nome.charAt(i))
            {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U': vogais++; break;
            case ' ': brancos++; break;
            default : consoantes++;
            }
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Vogais e consoantes</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Seu nome</h2>");
        out.println("<p>Qtde. de caracteres: " + nome.length() + "</p>");
        out.println("<p>Qtde. de vogais: " + vogais + "</p>");
        out.println("<p>Qtde. de consoantes: " + consoantes + "</p>");
        out.println("<p>Qtde. de espaços em branco: " + brancos + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}