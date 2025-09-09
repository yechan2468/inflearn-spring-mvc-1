package yechan.inflearn_spring_mvc_1.web.frontcontroller;

import lombok.Getter;

@Getter
public class ModelView {

    private final String viewName;
    private final MyModel model = new MyModel();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
