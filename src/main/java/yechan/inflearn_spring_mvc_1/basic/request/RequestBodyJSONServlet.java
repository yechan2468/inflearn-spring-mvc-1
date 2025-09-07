package yechan.inflearn_spring_mvc_1.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import yechan.inflearn_spring_mvc_1.basic.HelloData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJSONServlet", urlPatterns = "/request-body-json")
public class RequestBodyJSONServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        HelloData helloData = objectMapper.readValue(body, HelloData.class);

        response.getWriter().write("name=" + helloData.getUsername() + "\nage=" + helloData.getAge());
    }
    /*
    POST /request-body-json

    {
        "username": "hello",
        "age": 20
    }


    name=hello
    age=20
     */
}
