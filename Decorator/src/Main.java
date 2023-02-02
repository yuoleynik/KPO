abstract class UniversalCard {
    public String description = "Неизвестный документ.";

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}

abstract class UniversalCardDecorator extends UniversalCard {
    public abstract String getDescription();
}

class Pasport extends UniversalCard {
    public Pasport() {
        description = "Паспорт";
    }

    public int getCost() {
        return 500;
    }
}

class InsurancePolicy extends UniversalCard {
    public InsurancePolicy() {
        description = "Страховой полис";
    }

    public int getCost() {
        return 4000;
    }
}

class BankCard extends UniversalCard {
    public BankCard() {
        description = "Банковская карта";
    }

    public int getCost() {
        return 100;
    }
}

class ElectronicWallet extends UniversalCardDecorator {
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

class ElectronicSignature extends UniversalCardDecorator {
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

class PassportTranslation extends UniversalCardDecorator {
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

class Taxes extends UniversalCardDecorator {
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