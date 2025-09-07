package yechan.inflearn_spring_mvc_1.basic.response;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHTMLServlet", urlPatterns = "/response-html")
public class ResponseHTMLServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // servlet으로 HTML을 작성할 때에는 직접 다 만들어서 넣어줘야 함...
        response.getWriter().write("<html><body><h1>안 녕 !</h1></body></html>");
    }
    /*
    <html>

    <body>
        <h1>안 녕 !</h1>
    </body>

    </html>
     */
}
