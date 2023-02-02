enum CompanyType {
    LENOVO,
    SAMSUNG,
    IPHONE
}

abstract class Smartphone {
    void prepareSize() {
    }

    void preparePhone() {
    }

}

class BigLenovo extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём большой размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Lenovo и помещаем в коробку.");
    }
}

class BigSamsung extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём большой размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Samsung, крадём коробку.");
    }
}

class BigIphone extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём большой размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Iphone, откусываем яблоко и упаковываем.");
    }
}

class SmallLenovo extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём совсем маленький размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Lenovo и помещаем в коробку.");
    }
}

class SmallSamsung extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём совсем маленький размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Samsung, крадём коробку.");
    }
}

class SmallIphone extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём совсем маленький размер экрана.");
    }
    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Iphone, откусываем яблоко и упаковываем.");
    }
}


abstract class Factory {
    public Smartphone orderSmartphone(CompanyType type) {

        Smartphone smartphone = createSmartphone(type);

        smartphone.prepareSize();
        smartphone.preparePhone();

        System.out.println("Телефон готов!\n");
        return smartphone;
    }

    protected abstract Smartphone createSmartphone(CompanyType type);
}

class BigPhonesFactory extends Factory {
    @Override
    public Smartphone createSmartphone(CompanyType type) {
        Smartphone smartphone = null;
        switch (type) {
            case LENOVO:
                smartphone = new BigLenovo();
                break;
            case SAMSUNG:
                smartphone = new BigSamsung();
                break;
            case IPHONE:
                smartphone = new BigIphone();
                break;
        }
        return smartphone;
    }
}

class SmallPhonesFactory extends Factory {
    @Override
    public Smartphone createSmartphone(CompanyType type) {
        Smartphone smartphone = null;
        switch (type) {
            case LENOVO:
                smartphone = new SmallLenovo();
                break;
            case SAMSUNG:
                smartphone = new SmallSamsung();
                break;
            case IPHONE:
                smartphone = new SmallIphone();
                break;
        }
        return smartphone;
    }
}

public class Main {
    public static void main(String[] args) {
        Factory bigPhone = new BigPhonesFactory();
        bigPhone.orderSmartphone(CompanyType.SAMSUNG);

        Factory smallPhone1 = new SmallPhonesFactory();
        smallPhone1.orderSmartphone(CompanyType.LENOVO);

        Factory smallPhone2 = new SmallPhonesFactory();
        smallPhone2.orderSmartphone(CompanyType.IPHONE);
    }
}