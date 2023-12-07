package christmas;

import christmas.menu.Drink;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Event {
    private static final int DEFAULT_CHRISTMAS_DISCOUNT = 1_000;
    private static final int CHRISTMAS_DISCOUNT_INCREASE = 100;
    private static final int DISCOUNT_PER_MENU = 2_023;
    private static final int SPECIAL_DISCOUNT = 1_000;
    private static final int MIN_TOTAL_PRICE_FOR_EVENT = 10_000;
    private static final int MIN_TOTAL_PRICE_FOR_GIFT = 120_000;
    private final Order order;
    private final VisitDate visitDate;

    private final Map<Benefit, Integer> benefits = new HashMap<>();

    public Event(Order order, VisitDate visitDate) {
        this.order = order;
        this.visitDate = visitDate;

        calculateBenefits();
    }

    private void calculateBenefits() {
        if (order.calculateTotalPrice() < MIN_TOTAL_PRICE_FOR_EVENT) {
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
        if (visitDate.isInWeekDayPromotion()) {
            int discount = DISCOUNT_PER_MENU * order.countDessert();

            benefits.put(Benefit.WEEK_DAY, discount);
        }
    }

    private void calculateWeekendDiscount() {
        if (visitDate.isInWeekendPromotion()) {
            int discount = DISCOUNT_PER_MENU * order.countMain();

            benefits.put(Benefit.WEEKEND, discount);
        }
    }

    private void calculateSpecialDiscount() {
        if (visitDate.isInSpecialPromotion()) {
            benefits.put(Benefit.SPECIAL, SPECIAL_DISCOUNT);
        }
    }

    private void getGift() {
        if (order.calculateTotalPrice() >= MIN_TOTAL_PRICE_FOR_GIFT) {
            benefits.put(Benefit.GITF, Drink.CHAMPAGNE.getPrice());
        }
    }
    public int calculateTotalBenefitPrice() {
        return benefits.values()
                .stream()
                .mapToInt(benefitAmount -> benefitAmount)
                .sum();
    }

    public int calculateDiscountedPrice() {
        return order.calculateTotalPrice() - calculateTotalDiscount();
    }

    private int calculateTotalDiscount() {
        return benefits.entrySet()
                .stream()
                .filter(benefit -> benefit.getKey() != Benefit.GITF)
                .mapToInt(Entry::getValue)
                .sum();
    }

    public Badge getBadge() {
        int totalBenefitPrice = calculateTotalBenefitPrice();

        for (Badge badge : Badge.values()) {
            if (totalBenefitPrice >= badge.getTotalBenefitPrice()) {
                return badge;
            }
        }

        return Badge.NOTHING;
    }

    public Map<Benefit, Integer> getBenefits() {
        return Collections.unmodifiableMap(benefits);
    }

    public boolean doesGetGift() {
        return benefits.containsKey(Benefit.GITF);
    }

    public boolean doesNotGetBenefit() {
        return benefits.isEmpty();
    }
}
