package yechan.inflearn_spring_mvc_1.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.controller.MemberFormControllerV3;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.controller.MemberListControllerV3;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, MyController> handlerMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
        handlerMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v4/members", new MemberListControllerV3());

        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        MyController handler = handlerMap.get(requestURI);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getAvailableHandlerAdapter(handler);
        if (adapter == null) {
            throw new RuntimeException("handler adapter not found for handler " + handler);
        }

        ModelView mv = adapter.handle(request, response, handler);

        MyView view = getView(mv.getViewName());

        view.render(mv.getModel(), request, response);
    }

    private MyView getView(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyHandlerAdapter getAvailableHandlerAdapter(MyController handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.canSupport(handler)) {
                return adapter;
            }
        }
        return null;
    }
}
