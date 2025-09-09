package yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller;

import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> params, MyModel model) {
        return "new-form";
    }
}
