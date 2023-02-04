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