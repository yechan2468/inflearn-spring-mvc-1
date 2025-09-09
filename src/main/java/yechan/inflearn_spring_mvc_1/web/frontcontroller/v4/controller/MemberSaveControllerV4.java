package yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller;

import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> params, MyModel model) {
        String username = params.get("username");
        int age = Integer.parseInt(params.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);

        return "save-result";
    }
}
