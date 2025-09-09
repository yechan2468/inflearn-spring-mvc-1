package yechan.inflearn_spring_mvc_1.web.springmvc.v1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;

import java.util.List;

@Controller
public class MemberControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView list() {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");

        mv.addObject("members", members);

        return mv;
    }
}
