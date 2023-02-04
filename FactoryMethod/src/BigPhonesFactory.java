public class BigPhonesFactory extends Factory {
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
