package christmas.view;

import static christmas.ChristmasConstants.INVALID_VISIT_DATE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        String input = Console.readLine();

        return parseIntWithIllegalArgumentException(input);
    }

    private Integer parseIntWithIllegalArgumentException(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_VISIT_DATE);
        }
    }
}
