package com.example.SU23B2_SOF3011_SD18105;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String name = request.getParameter("ten");
        System.out.println(name);
        request.setAttribute("name1", name);
        request.getRequestDispatcher("/views/hello.jsp")
            .forward(request, response);
    }
}