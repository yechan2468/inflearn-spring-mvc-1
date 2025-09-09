package yechan.inflearn_spring_mvc_1.web.springmvc.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyModel;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.util.Util;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.ControllerV4;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller.MemberFormControllerV4;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller.MemberListControllerV4;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private final Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> params = Util.getParams(request);

        MyModel model = new MyModel();
        String viewName = controller.process(params, model);

        MyView view = getView(viewName);

        view.render(model, request, response);
    }

    private static MyView getView(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
