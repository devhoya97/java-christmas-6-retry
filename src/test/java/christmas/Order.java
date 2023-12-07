package christmas;

import christmas.menu.Appetizer;
import christmas.menu.Dessert;
import christmas.menu.Drink;
import christmas.menu.Main;
import christmas.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    private final Map<Menu, Integer> order;

    public Order(Map<String, Integer> order) {
        validatePrepared(order);
        validateTotalMenuNumber(order);


    }

    private Menu findMenu(String name) {
        List<Menu> preparedMenus = getPreparedMenus();
        return null;
    }

    private List<Menu> getPreparedMenus() {
        List<Menu> preparedMenus = new ArrayList<>();

        preparedMenus.addAll(Appetizer.getPreparedMenus());
        preparedMenus.addAll(Main.getPreparedMenus());
        preparedMenus.addAll(Dessert.getPreparedMenus());
        preparedMenus.addAll(Drink.getPreparedMenus());

        return preparedMenus;
    }

    private void validatePrepared(Map<String, Integer> order) {

    }

    private void validateTotalMenuNumber(Map<String, Integer> order) {

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
