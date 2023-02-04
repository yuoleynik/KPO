public class ElectronicSignature extends UniversalCardDecorator {
    UniversalCard universalCard;

    public ElectronicSignature(UniversalCard universalCard) {
        this.universalCard = universalCard;
    }

    public String getDescription() {
        return universalCard.getDescription() + ", Электронная подпись";
    }

    public int getCost() {
        return 500 + universalCard.getCost();
    }
}
