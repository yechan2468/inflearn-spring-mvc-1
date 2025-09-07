package yechan.inflearn_spring_mvc_1.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
    /*
    GET /hello?username=yechan

    HelloServlet.service
    request = org.apache.catalina.connector.RequestFacade@7ceddf7b
    response = org.apache.catalina.connector.ResponseFacade@3ab91dd4
    username = yechan

    hello yechan
     */

    // RequestFacade, ResponseFacade: 서블릿 표준 스펙 구현체
}
