package christmas;

import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> orderInput = new HashMap<>();
        orderInput.put("티본스테이크", 1);
        orderInput.put("바비큐립", 1);
        orderInput.put("초코케이크", 2);
        orderInput.put("제로콜라", 1);

        Order order = new Order(orderInput);
        OutputView outputView = new OutputView();
        outputView.printOrder(order);

        VisitDate visitDate = new VisitDate(3);
        Event event = new Event(order, visitDate);
        outputView.printEventResult(event);
    }
}
