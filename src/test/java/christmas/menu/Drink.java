package christmas.menu;

public enum Drink implements Menu {
    ;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean isMain() {
        return false;
    }

    @Override
    public boolean isDessert() {
        return false;
    }
}
