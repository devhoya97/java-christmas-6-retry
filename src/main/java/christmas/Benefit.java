package christmas;

public enum Benefit {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEK_DAY("평일 할인"),
    WEEKEND("주말"),
    SPECIAL("특별"),
    GITF("샴페인 1개");

    private final String name;

    Benefit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
