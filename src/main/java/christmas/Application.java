package christmas;

import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> orderInput = new HashMap<>();
        orderInput.put("해산물파스타", 2);
        orderInput.put("초코케이크", 2);

        Order order = new Order(orderInput);
        OutputView outputView = new OutputView();
        outputView.printOrder(order);
    }
}
