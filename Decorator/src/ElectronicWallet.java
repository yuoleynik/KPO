public class ElectronicWallet extends UniversalCardDecorator {
    UniversalCard universalCard;

    public ElectronicWallet(UniversalCard universalCard) {
        this.universalCard = universalCard;
    }

    public String getDescription() {
        return universalCard.getDescription() + ", Электронный кошелёк";
    }

    public int getCost() {
        return 50 + universalCard.getCost();
    }
}
