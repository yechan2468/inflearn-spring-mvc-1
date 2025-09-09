package yechan.inflearn_spring_mvc_1.web.frontcontroller.v3;

import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> params);
}
