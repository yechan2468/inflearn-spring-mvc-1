package yechan.inflearn_spring_mvc_1.web.frontcontroller.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
                paramName -> params.put(paramName, request.getParameter(paramName))
        );
        return params;
    }
}
