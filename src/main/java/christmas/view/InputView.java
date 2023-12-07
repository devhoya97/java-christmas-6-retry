package christmas.view;

import static christmas.ChristmasConstants.INVALID_ORDER;
import static christmas.ChristmasConstants.INVALID_VISIT_DATE;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_COUNT_DELIMITER = "-";
    private static final int MENU_AND_COUNT_LENGTH = 2;
    public int getVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        String input = Console.readLine().trim();

        return parseIntWithIllegalArgumentException(input);
    }

    private Integer parseIntWithIllegalArgumentException(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_VISIT_DATE);
        }
    }

    public Map<String, Integer> getOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        String[] inputs = Console.readLine().split(ORDER_DELIMITER);

        Map<String, Integer> order = new HashMap<>();
        for (String input : inputs) {
            String[] menuAndCount = input.split(MENU_COUNT_DELIMITER);
            validateMenuAndCountLength(menuAndCount);

            order.put(menuAndCount[0], parseIntWithIllegalArgumentException(menuAndCount[1].trim()));
        }

        return order;
    }

    private void validateMenuAndCountLength(String[] menuAndCount) {
        if (menuAndCount.length != MENU_AND_COUNT_LENGTH) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
