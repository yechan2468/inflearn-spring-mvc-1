package yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.adapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.util.Util;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.ControllerV4;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.MyHandlerAdapter;

import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean canSupport(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, MyController handler) {
        Map<String, String> params = Util.getParams(request);

        MyModel model = new MyModel();
        String viewName = ((ControllerV4) handler).process(params, model);

        ModelView modelView = new ModelView(viewName);
        modelView.getModel().putAll(model);

        return modelView;
    }
}
