package yechan.inflearn_spring_mvc_1.basic.response;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        response.setStatus(HttpServletResponse.SC_OK);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        // redirect
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/");
        response.sendRedirect("/");
    }
    /*
    HTTP/1.1 302
    Cache-Control: no-cache, no-store, must-revalidate
    Pragma: no-cache
    Set-Cookie: myCookie=good; Max-Age=600; Expires=Sun, 07 Sep 2025 07:36:02 GMT
    Location: http://localhost:8080/
    Content-Type: text/plain;charset=utf-8
    Content-Length: 0
    Date: Sun, 07 Sep 2025 07:26:02 GMT
    Keep-Alive: timeout=60
    Connection: keep-alive
     */

}
