public class BigIphone extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём большой размер экрана.");
    }

    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Iphone, откусываем яблоко и упаковываем.");
    }
}
