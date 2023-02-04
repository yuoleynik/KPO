public class BigLenovo extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём большой размер экрана.");
    }

    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Lenovo и помещаем в коробку.");
    }
}
