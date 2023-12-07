package christmas.menu;

import java.util.Arrays;
import java.util.List;

public enum Appetizer implements Menu {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_000),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String name;
    private final int price;

    Appetizer(String name, int price) {
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
        return Arrays.asList(Appetizer.values());
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
        return false;
    }
}
