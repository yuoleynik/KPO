import java.util.Scanner;

public class Menu {
    Game game = new Game();
    Scanner in = new Scanner(System.in);

    // Выбор игрока: играть с ботом или с игроком.
    String mode;

    // Метод для выбора режима игры.
    void chooseMode() {
        int count = 0;
        System.out.print("Меню." +
                "\n1. Игра против лёгкого бота - '1'" +
                "\n2. Игрок против игрока - '2'\n");
        do {
            if (count > 0) {
                System.out.print("Введите значение 1 или 2.\n");
            }
            mode = in.nextLine();
            count++;
        } while (!mode.equals("1") && !mode.equals("2"));

        if (mode.equals("1")) {
            game.easyBot();
            game.gameOver();
        } else {
            game.playWithPlayer2();
            game.gameOver();
        }

    }

    // Метод для выбора: продолжить игру или выйти.
    String suggestToExit() {
        String choice;
        System.out.print("Игра окончена." +
                "\nЖелаете продолжить?" +
                "\nВведите 'e', чтобы выйти" +
                "\nИли любую клавишу, чтобы продолжить.\n");
        choice = in.nextLine();
        return choice;
    }

}
