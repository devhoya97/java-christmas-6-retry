package christmas.menu;

import java.util.List;

public interface Menu {
    public String getName();

    public int getPrice();

    public static List<Menu> getPreparedMenus(){
        return null;
    };

    public boolean isMain();

    public boolean isDessert();

    public boolean isDrink();
}
