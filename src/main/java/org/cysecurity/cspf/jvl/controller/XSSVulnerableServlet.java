package org.cysecurity.cspf.jvl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "XSSVulnerableServlet", urlPatterns = {"/xss"})
public class XSSVulnerableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the 'input' parameter from the request
        String userInput = request.getParameter("input");

        // Vulnerable code: directly reflecting user input into the response
        out.println("<html>");
        out.println("<head><title>XSS Test</title></head>");
        out.println("<body>");
        out.println("<h1>XSS Vulnerability Test</h1>");
        out.println("<p>You entered: " + userInput + "</p>"); // No sanitization applied
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Servlet that demonstrates an XSS vulnerability by reflecting user input.";
    }
}