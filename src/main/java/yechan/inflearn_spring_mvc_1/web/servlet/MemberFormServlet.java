package yechan.inflearn_spring_mvc_1.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("""
                <!DOCTYPE html>
                    <head>
                        <meta charset="utf-8">
                        <title>Title</title>
                    </head>
                    <body>
                        <form action="/servlet/members/save" method="post" class="form-example">
                          <div class="form-example">
                            <label for="username">Enter your username: </label>
                            <input type="text" name="username" id="username" required />
                          </div>
                          <div class="form-example">
                            <label for="age">Enter your age: </label>
                            <input type="age" name="age" id="age" required />
                          </div>
                          <div class="form-example">
                            <input type="submit" value="register" />
                          </div>
                        </form>
                    </body>
                </html>
                """);
    }
}
