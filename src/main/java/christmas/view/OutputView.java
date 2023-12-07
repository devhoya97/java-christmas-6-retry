package christmas.view;

import christmas.Benefit;
import christmas.Event;
import christmas.Order;
import christmas.menu.Menu;
import java.text.DecimalFormat;
import java.util.Map.Entry;

public class OutputView {

    private static final String MINUS = "-";
    private static final String BENEFIT_DELIMITER = ": ";
    private static final String NOTHING = "없음";
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

    public void printEventResult(Event event) {
        StringBuilder message = new StringBuilder();

        addGiftMessage(event, message);
        addTotalBenefitMessage(event, message);

        System.out.println(message);
    }

    private void addGiftMessage(Event event, StringBuilder message) {
        message.append("<증정 메뉴>").append(NEW_LINE);

        if (event.doesGetGift()) {
            message.append("샴페인 1개").append(DOUBLE_NEW_LINE);
            return;
        }

        message.append(NOTHING).append(DOUBLE_NEW_LINE);
    }

    private void addTotalBenefitMessage(Event event, StringBuilder message) {
        message.append("<혜택 내역>").append(NEW_LINE);

        if (event.doesNotGetBenefit()) {
            message.append(NOTHING).append(DOUBLE_NEW_LINE);
            return;
        }

        for (Entry<Benefit, Integer> benefit : event.getBenefits().entrySet()) {
            message.append(benefit.getKey().getName()).append(BENEFIT_DELIMITER)
                    .append(formatWithComma(benefit.getValue())).append("원").append(NEW_LINE);
        }
        message.append(NEW_LINE);
    }

}
