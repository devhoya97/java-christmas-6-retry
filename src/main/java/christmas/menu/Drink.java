package christmas.menu;

import java.util.Arrays;
import java.util.List;

public enum Drink implements Menu {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public static List<Menu> getPreparedMenus() {
        return Arrays.asList(Drink.values());
    }

    @Override
    public boolean isMain() {
        return false;
    }

    @Override
    public boolean isDessert() {
        return false;
    }

    @Override
    public boolean isDrink() {
        return true;
    }
}
