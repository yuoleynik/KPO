public abstract class Factory {
    public Smartphone orderSmartphone(CompanyType type) {

        Smartphone smartphone = createSmartphone(type);

        smartphone.prepareSize();
        smartphone.preparePhone();

        System.out.println("Телефон готов!\n");
        return smartphone;
    }

    protected abstract Smartphone createSmartphone(CompanyType type);
}
