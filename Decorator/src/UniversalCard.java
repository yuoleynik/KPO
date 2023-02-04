public abstract class UniversalCard {
    public String description = "Неизвестный документ.";

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}
