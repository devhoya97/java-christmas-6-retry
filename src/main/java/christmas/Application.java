package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final InputView inputview = new InputView();
    private static final OutputView outputview = new OutputView();

    public static void main(String[] args) {
        outputview.printStart();

        VisitDate visitDate = getValidVisitDate();
        Order order = getValidOrder();
        Event event = new Event(order, visitDate);

        outputview.printOrder(order);
        outputview.printEventResult(event);
    }

    private static VisitDate getValidVisitDate() {
        while (true) {
            try {
                return new VisitDate(inputview.getVisitDate());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputview.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static Order getValidOrder() {
        while (true) {
            try {
                return new Order(inputview.getOrder());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputview.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
