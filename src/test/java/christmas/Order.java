package christmas;

import static christmas.ChristmasConstants.INVALID_ORDER;

import christmas.menu.Appetizer;
import christmas.menu.Dessert;
import christmas.menu.Drink;
import christmas.menu.Main;
import christmas.menu.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Order {
    private static final int MAX_MENU_COUNT = 20;

    private final Map<Menu, Integer> order = new HashMap<>();

    public Order(Map<String, Integer> order) {
        for (Entry<String, Integer> orderEntry : order.entrySet()) {
            Menu orderedMenu = findMenu(orderEntry.getKey());
            this.order.put(orderedMenu, orderEntry.getValue());
        }
    }

    private Menu findMenu(String name) {
        List<Menu> preparedMenus = getPreparedMenus();

        for (Menu preparedMenu : preparedMenus) {
            if (preparedMenu.getName().equals(name)) {
                return preparedMenu;
            }
        }

        throw new IllegalArgumentException(INVALID_ORDER);
    }

    private List<Menu> getPreparedMenus() {
        List<Menu> preparedMenus = new ArrayList<>();

        preparedMenus.addAll(Appetizer.getPreparedMenus());
        preparedMenus.addAll(Main.getPreparedMenus());
        preparedMenus.addAll(Dessert.getPreparedMenus());
        preparedMenus.addAll(Drink.getPreparedMenus());

        return preparedMenus;
    }

    private void validateTotalMenuNumber(Map<String, Integer> order) {
        int menuCountSum = order.values()
                .stream()
                .mapToInt(menuCount -> menuCount)
                .sum();

        if (menuCountSum > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void validateOnlyDrink(Map<Menu, Integer> order) {

    }

    public int totalPrice() {
        return 0;
    }

    public int countMain() {
        return 0;
    }

    public int countDessert() {
        return 0;
    }
}
