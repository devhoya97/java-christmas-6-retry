package christmas.view;

import christmas.Order;
import christmas.menu.Menu;
import java.text.DecimalFormat;
import java.util.Map.Entry;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_NEW_LINE = "\n\n";
    private static final String SPACE = " ";
    private static final String MONEY_PATTERN = "#,###";

    public void printOrder(Order order) {
        StringBuilder message = new StringBuilder();

        message.append("<주문 메뉴>").append(NEW_LINE);
        for (Entry<Menu, Integer> orderItem : order.getOrder().entrySet()) {
            message.append(orderItem.getKey().getName()).append(SPACE)
                    .append(orderItem.getValue()).append("개").append(NEW_LINE);
        }

        message.append(NEW_LINE).append("<할인 전 총주문 금액>").append(NEW_LINE)
                .append(formatWithComma(order.calculateTotalPrice())).append("원").append(NEW_LINE);

        System.out.println(message);
    }

    private String formatWithComma(int number) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_PATTERN);

        return decimalFormat.format(number);
    }
}
