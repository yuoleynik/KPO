public class SmallIphone extends Smartphone {
    @Override
    void prepareSize() {
        System.out.println("Берём совсем маленький размер экрана.");
    }

    @Override
    void preparePhone() {
        System.out.println("Относим телефон в компанию Iphone, откусываем яблоко и упаковываем.");
    }
}
