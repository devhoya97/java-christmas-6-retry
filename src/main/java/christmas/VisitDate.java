package christmas;

import static christmas.ChristmasConstants.INVALID_VISIT_DATE;

public class VisitDate {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int CHRISTMAS_DATE = 25;
    private static final int WEEK_SIZE = 7;
    private static final int FRIDAY_REMAINDER = 1;
    private static final int SATURDAY_REMAINDER = 2;
    private static final int SUNDAY_REMAINDER = 3;
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
        return date - MIN_DATE;
    }

    public boolean isInSpecialPromotion() {
        return ((date % WEEK_SIZE == SUNDAY_REMAINDER) || (date == CHRISTMAS_DATE));
    }

    public boolean isInWeekDayPromotion() {
        return false;
    }

    public boolean isInWeekendPromotion() {
        int dateRemainder = date % WEEK_SIZE;
        
        return dateRemainder == FRIDAY_REMAINDER || dateRemainder == SATURDAY_REMAINDER;
    }
}
