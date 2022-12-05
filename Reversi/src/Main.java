public class Main {
    public static void main(String[] args) {
        String choice;
        do {
            Menu menu = new Menu();
            menu.chooseMode();
            choice = menu.suggestToExit();
        } while (!choice.equals("e"));
    }
}