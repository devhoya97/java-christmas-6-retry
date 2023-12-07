package christmas.menu;

import java.util.Arrays;
import java.util.List;

public enum Main implements Menu {
    T_BONE_STEAK("티본스테이크", 55_000),
    BBQ_RIB("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);

    private final String name;
    private final int price;

    Main(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    public static List<Menu> getPreparedMenus() {
        return Arrays.asList(Main.values());
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
