package yechan.inflearn_spring_mvc_1.web.frontcontroller.v3;

import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;

import java.util.Map;

public interface ControllerV3 extends MyController {

    ModelView process(Map<String, String> params);
}
