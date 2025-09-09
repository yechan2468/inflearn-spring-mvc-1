package yechan.inflearn_spring_mvc_1.web.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyController;
import yechan.inflearn_spring_mvc_1.web.frontcontroller.MyView;

import java.io.IOException;

public interface ControllerV2 extends MyController {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
