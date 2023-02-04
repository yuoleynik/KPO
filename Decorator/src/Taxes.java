public class Taxes extends UniversalCardDecorator {
    UniversalCard universalCard;

    public Taxes(UniversalCard universalCard) {
        this.universalCard = universalCard;
    }

    public String getDescription() {
        return universalCard.getDescription() + ", Оплата налогов";
    }

    public int getCost() {
        return 3000 + universalCard.getCost();
    }
}
