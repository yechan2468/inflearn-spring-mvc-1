package yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.util.Util;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.ControllerV3;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean canSupport(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, MyController handler) {
        ControllerV3 controllerV3 = (ControllerV3) handler;

        Map<String, String> params = Util.getParams(request);
        ModelView modelView = controllerV3.process(params);

        return modelView;
    }
}
