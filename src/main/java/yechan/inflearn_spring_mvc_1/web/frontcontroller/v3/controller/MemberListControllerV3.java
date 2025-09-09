package yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.controller;

import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> params) {
        List<Member> members = memberRepository.findAll();

        ModelView modelView = new ModelView("members");

        modelView.getModel().put("members", members);

        return modelView;
    }
}
