package com.bobocode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

    private static final String SPRING_APP_CONTEXT = "SPRING_APP_CONTEXT";

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute(SPRING_APP_CONTEXT, new AnnotationConfigApplicationContext(NameProvider.class));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext springContext = (ApplicationContext) req.getServletContext().getAttribute(SPRING_APP_CONTEXT);
        PrintWriter writer = resp.getWriter();
        writer.println(springContext.getBean(NameProvider.class).getName());
        writer.flush();
        writer.close();
    }
}
