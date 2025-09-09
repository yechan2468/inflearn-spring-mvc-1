package yechan.inflearn_spring_mvc_1.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.ModelView;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean canSupport(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, MyController handler) throws ServletException, IOException;
}
