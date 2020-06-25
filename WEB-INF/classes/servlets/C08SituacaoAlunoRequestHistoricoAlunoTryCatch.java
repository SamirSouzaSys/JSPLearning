package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class C08SituacaoAlunoRequestHistoricoAlunoTryCatch extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String situacao;
        char sexo;
        float nota1 = 0, nota2 = 0;
        boolean notasOk;
        PrintWriter out;
        resp.setContentType("text/html");
        out = resp.getWriter();
        if (req.getParameter("sexo") != null)
            sexo = req.getParameter("sexo").charAt(0);
        else
            sexo = ' ';
        //tratamento de exceção
        try{
            nota1 = Float.parseFloat(
            req.getParameter("nota1").replace(',', '.'));
            nota2 = Float.parseFloat(
            req.getParameter("nota2").replace(',', '.'));
            notasOk = true;
        }
        catch (Exception e)
        {
            notasOk = false;
        }

        if (notasOk)
        {
            if ((nota1 + nota2) / 2 >= 7)
            {
                if (sexo == 'F')
                    situacao = "Aprovada";
                else
                    situacao = "Aprovado";
            }
            else
            {
                if (sexo == 'F')
                    situacao = "Reprovada";
                else
                    situacao = "Reprovado";
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Histórico Escolar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Histórico Escolar</h2>");
            out.println("<p>Nome: " + req.getParameter("nome") + "</p>");
            out.println("<p>Média: " + ( (nota1 + nota2) / 2 ) + "</p>");
            out.println("<p>Situação: " + situacao + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Histárico Escolar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Histórico Escolar</h2>");
            out.println("<p>A(s) nota(s) não é(são) válida(s).</p>");
            out.println("<p>Favor verificar e digitar novamente.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}