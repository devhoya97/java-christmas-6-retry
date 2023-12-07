package christmas.menu;

import java.util.Arrays;
import java.util.List;

public enum Dessert implements Menu {
    CHOKO_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final int price;

    Dessert(String name, int price) {
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
        return Arrays.asList(Dessert.values());
    }

    @Override
    public boolean isMain() {
        return false;
    }

    @Override
    public boolean isDessert() {
        return true;
    }

    @Override
    public boolean isDrink() {
        return false;
    }
}
