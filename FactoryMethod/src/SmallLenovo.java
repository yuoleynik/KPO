public class SmallLenovo extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём совсем маленький размер экрана.");
    }

    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Lenovo и помещаем в коробку.");
    }
}
