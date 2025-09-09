package yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.controller;

import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> params) {
        return new ModelView("new-form");
    }
}
