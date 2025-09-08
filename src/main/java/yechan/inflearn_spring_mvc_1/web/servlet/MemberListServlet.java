package yechan.inflearn_spring_mvc_1.web.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Member> members = memberRepository.findAll();

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
                        <ul>
                """);

        for (Member member : members) {
            writer.write("<li>id = " + member.getId()
                    + "\tusername = " + member.getUsername()
                    + "\tage = " + member.getAge() + "</li>");
        }

        writer.write("""
                        </ul>
                    </body>
                </html>
                """);
    }
}
