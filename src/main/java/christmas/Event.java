package christmas;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private static final int DEFAULT_CHRISTMAS_DISCOUNT = 1_000;
    private static final int CHRISTMAS_DISCOUNT_INCREASE = 100;
    private static final int MIN_TOTAL_PRICE = 10_000;
    private final Order order;
    private final VisitDate visitDate;

    private Map<Benefit, Integer> benefits = new HashMap<>();

    public Event(Order order, VisitDate visitDate) {
        this.order = order;
        this.visitDate = visitDate;

        calculateBenefits();
    }

    private void calculateBenefits() {
        if (order.calculateTotalPrice() < MIN_TOTAL_PRICE) {
            return;
        }

        calculateChristmasDiscount();
        calculateWeekDayDiscount();
        calculateWeekendDiscount();
        calculateSpecialDiscount();
        getGift();
    }

    private void calculateChristmasDiscount() {
        if (visitDate.isInChristmasPromotion()) {
            int discount = DEFAULT_CHRISTMAS_DISCOUNT +
                    (CHRISTMAS_DISCOUNT_INCREASE * visitDate.countDifferenceFromFirstDate());

            benefits.put(Benefit.CHRISTMAS, discount);
        }
    }

    private void calculateWeekDayDiscount() {

    }

    private void calculateWeekendDiscount() {

    }

    private void calculateSpecialDiscount() {

    }

    private void getGift() {
        
    }
    public int calculateTotalBenefitPrice() {
        return 0;
    }

    public int calculateTotalDiscountPrice() {
        return 0;
    }

    public int calculateDiscountedPrice() {
        return 0;
    }

    public Badge getBadge() {
        return null;
    }
}
