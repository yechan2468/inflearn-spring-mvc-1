package yechan.inflearn_spring_mvc_1.web.frontcontroller.v4;

import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;

import java.util.Map;

public interface ControllerV4 extends MyController {

    String process(Map<String, String> params, MyModel model);
}
