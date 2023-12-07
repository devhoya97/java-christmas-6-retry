package christmas;

import static christmas.ChristmasConstants.INVALID_VISIT_DATE;

public class VisitDate {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int CHRISTMAS_DATE = 25;
    private final int date;

    public VisitDate(int date) {
        validateDecember(date);
        this.date = date;
    }

    private void validateDecember(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(INVALID_VISIT_DATE);
        }
    }

    public boolean isInChristmasPromotion() {
        return date <= CHRISTMAS_DATE;
    }

    public int countDifferenceFromFirstDate() {
        return 0;
    }

    public boolean isInSpecialPromotion() {
        return false;
    }

    public boolean isInWeekDayPromotion() {
        return false;
    }

    public boolean isInWeekendPromotion() {
        return false;
    }
}
