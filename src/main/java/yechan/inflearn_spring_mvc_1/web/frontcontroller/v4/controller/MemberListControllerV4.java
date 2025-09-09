package yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller;

import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> params, MyModel model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);

        return "members";
    }
}
