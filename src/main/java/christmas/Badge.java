package christmas;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NOTHING("없음", 0);

    private final String name;
    private final int totalBenefitPrice;

    Badge(String name, int totalBenefitPrice) {
        this.name = name;
        this.totalBenefitPrice = totalBenefitPrice;
    }

    public String getName() {
        return name;
    }

    public int getTotalBenefitPrice() {
        return totalBenefitPrice;
    }
}
