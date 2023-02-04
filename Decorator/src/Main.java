public class Main {
    public static void main(String[] args) {
        UniversalCard universalCard1 = new Pasport();
        universalCard1 = new PassportTranslation(universalCard1);
        System.out.println("Услуги: " + universalCard1.getDescription()
                + ".\nСтоимость: " + universalCard1.getCost() + " рублей.\n");

        UniversalCard universalCard2 = new InsurancePolicy();
        universalCard2 = new ElectronicSignature(universalCard2);
        universalCard2 = new Taxes(universalCard2);
        System.out.println("Услуги: " + universalCard2.getDescription()
                + ".\nСтоимость: " + universalCard2.getCost() + " рублей.\n");

        UniversalCard universalCard3 = new BankCard();
        universalCard3 = new ElectronicWallet(universalCard3);
        System.out.println("Услуги: " + universalCard3.getDescription()
                + ".\nСтоимость: " + universalCard3.getCost() + " рублей.\n");

    }
}