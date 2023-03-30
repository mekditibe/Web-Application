package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show calculator page

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result page
        PrintWriter out = response.getWriter();


        Integer number1 = Integer.parseInt(request.getParameter("number1"));
        Integer number2 = Integer.parseInt(request.getParameter("number2"));
        String op = request.getParameter("op");
        Integer output =0;
        out.println("<html>");
        out.println("<head><title>HelloServlet</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");

        switch (op){
            case "/":
                output=(number1/number2);
                out.println("The result of "+number1 + " "+ op +" "+ number2+ " = "+ (number1/number2));
                break;
            case "-":
                output=(number1-number2);
                out.println("The result of "+number1 + " "+ op +" "+ number2+ " = "+ (number1-number2));
                break;
            case "+":
                output=(number1+number2);
                out.println("The result of "+number1 + " "+ op +" "+ number2+ " = "+ (number1+number2));
                break;
            case "*":
                output=(number1*number2);
                out.println("The result of "+number1 + " "+ op +" "+ number2+ " = "+ (number1*number2) );
                break;
        }
        out.println("<body bgcolor=\"#ffffff\">");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>first </th>");
        out.println("<th>operation </th>");
        out.println("<th>second </th>");
        out.println("<th> result </th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>"+number1+" </td>");
        out.println("<td>"+number2+" </td>");
        out.println("<td>"+op+" </td>");
        out.println("<td>"+output+" </td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

}
