import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);

    // Максимальный счёт первого игрока.
    private static int MAX_OF_USER1 = 0;

    // Максимальный счёт второго игрока.
    private static int MAX_OF_USER2 = 0;
    Field field;

    // Метод, запускающий игру с ботом.
    // Откат назад нереализован, но взят в комментарии, поскольку не работает копирование.
    void easyBot() {
        field = new Field();
        int countOfPlayersMoves = 0;
        field.printField('●');
        int choice = 0;
        String choiceOfMoveBackward;
        do {
            boolean flag;
            do {
                try {
                    choice = field.scanInt();
                    flag = false;
                } catch (Exception error) {
                    System.out.print("Похоже, вы ввели буквы, а не число" +
                            "\nПопробуйте ещё раз.\n");
                    flag = true;
                }
            } while (flag);
            countOfPlayersMoves++;

            if (choice != -1) {
                field.createListOfMove('●');
                field.changeField(choice - 11, '●');
                System.out.print("Ход Игрока1 завершён. Ходит Игрок2.\n");
                field.printField('◯');
            } else {
                System.out.print("Похоже, ходов нет, вы пропускаете ход.\n");
                field.createListOfMove('●');
                System.out.print("Ход Игрока1 завершён. Ходит Игрок2.\n");
                field.printField('◯');
            }

            field.createArrayOfGradesNewbie();

            System.out.print("Ход Игрока2 завершён. Ходит Игрок1.\n");
            field.printField('●');
            countOfPlayersMoves++;

            /*  if (countOfPlayersMoves > 2) {
                System.out.print("Откатить 2 хода назад?" +
                        "\n'y' - Да" +
                        "\nДругой символ для продолжения.\n");
                choiceOfMoveBackward = in.nextLine();
                if (choiceOfMoveBackward.equals("y")) {
                    field.stackOfMoves.pop();
                    field.stackOfMoves.pop();
                    Field.Cell[][] fieldCopy = field.stackOfMoves.top();
                    for (var i = 0; i < 8; i++) {
                        for (var j = 0; j < 8; j++) {
                            field.field[i][j] = fieldCopy[i][j];
                        }
                    }
                    field.printField('●');
                }
            } else {
                System.out.print("Нет возможности откатить на шаг назад, " +
                        "\nтак как проделано недостаточно ходов.\n");
            }*/

        } while (field.checkFull() && field.checkOneColor());
    }

    // Метод, запускающий игру с игроком.
    // Откат назад здесь нереализован, так как не работает с ботом.
    void playWithPlayer2() {
        field = new Field();
        field.printField('●');
        int choice1 = 0;
        int choice2 = 0;

        do {
            boolean flag;
            do {
                try {
                    choice1 = field.scanInt();
                    flag = false;
                } catch (Exception error) {
                    System.out.print("Похоже, вы ввели буквы, а не число" +
                            "\nПопробуйте ещё раз.\n");
                    flag = true;
                }
            } while (flag);
            if (choice1 != -1) {
                field.createListOfMove('●');
                field.changeField(choice1 - 11, '●');
                System.out.print("Ход Игрока1 завершён. Ходит Игрок2.\n");
                field.printField('◯');
            } else {
                System.out.print("Похоже, ходов нет, вы пропускаете ход.\n");
                field.createListOfMove('●');
                System.out.print("Ход Игрока1 завершён. Ходит Игрок2.\n");
                field.printField('◯');
            }
            do {
                try {
                    choice2 = field.scanInt();
                    flag = false;
                } catch (Exception error) {
                    System.out.print("Похоже, вы ввели буквы, а не число" +
                            "\nПопробуйте ещё раз.\n");
                    flag = true;
                }
            } while (flag);
            if (choice2 != -1) {
                field.createListOfMove('◯');
                field.changeField(choice2 - 11, '◯');
                System.out.print("Ход Игрока2 завершён. Ходит Игрок1.\n");
                field.printField('●');
            } else {
                System.out.print("Похоже, ходов нет, вы пропускаете ход.\n");
                field.createListOfMove('◯');
                System.out.print("Ход Игрока2 завершён. Ходит Игрок1.\n");
                field.printField('●');
            }

        } while (field.checkFull() && field.checkOneColor());
    }

    // Метод, который запускается после окончания игры.
    void gameOver() {
        int count1 = field.countOfFirstPlayer();
        int count2 = field.countOfSecondPlayer();
        if (count1 > MAX_OF_USER1)
            MAX_OF_USER1 = count1;
        if (count2 > MAX_OF_USER2)
            MAX_OF_USER2 = count2;
        if (count1 > count2) {
            System.out.print("Победил Игрок1!" +
                    "\nСчёт: " + count1 + " " + count2 +
                    "\nМаксимальный счёт Игрока1: " + MAX_OF_USER1 +
                    "\nМаксимальный счёт Игрока2: " + MAX_OF_USER2 + "\n");
        } else if (count1 < count2) {
            System.out.print("Победил Игрок2!" +
                    "\nСчёт: " + count1 + " " + count2 +
                    "\nМаксимальный счёт Игрока1: " + MAX_OF_USER1 +
                    "\nМаксимальный счёт Игрока2: " + MAX_OF_USER2 + "\n");
        } else {
            System.out.print("Победила Дружба!" +
                    "\nСчёт: " + count1 + " " + count2 +
                    "\nМаксимальный счёт Игрока1: " + MAX_OF_USER1 +
                    "\nМаксимальный счёт Игрока2: " + MAX_OF_USER2 + "\n");
        }
    }

}
