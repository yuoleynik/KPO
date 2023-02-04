public class PassportTranslation extends UniversalCardDecorator {
    UniversalCard universalCard;

    public PassportTranslation(UniversalCard universalCard) {
        this.universalCard = universalCard;
    }

    public String getDescription() {
        return universalCard.getDescription() + ", Перевод паспорта";
    }

    public int getCost() {
        return 900 + universalCard.getCost();
    }
}
