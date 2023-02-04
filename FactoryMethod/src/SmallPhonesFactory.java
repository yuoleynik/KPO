public class SmallPhonesFactory extends Factory {
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
