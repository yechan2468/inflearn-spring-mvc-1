package yechan.inflearn_spring_mvc_1.web.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                     "    <head>\n" +
                     "        <meta charset=\"utf-8\">\n" +
                     "        <title>Title</title>\n" +
                     "    </head>\n" +
                     "    <body>\n" +
                     "        성공\n" +
                     "        <ul>\n" +
                     "        <li>id=" + member.getId() +"</li>\n" +
                     "        <li>username=" + member.getUsername() +"</li>\n" +
                     "        <li>age=" + member.getAge() +"</li>\n" +
                     "        </ul>\n" +
                     "    </body>\n" +
                     "</html>\n");
    }
}
