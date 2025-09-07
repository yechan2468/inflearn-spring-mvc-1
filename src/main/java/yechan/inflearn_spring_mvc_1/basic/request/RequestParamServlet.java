package yechan.inflearn_spring_mvc_1.basic.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(name -> System.out.println(name + " " + request.getParameter(name)));
    }
    /*
    GET /request-param?username=yechan&age=20
    POST /request-param    username=yechan&age=20

    username yechan
    age 20
     */
}
