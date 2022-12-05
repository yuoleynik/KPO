import java.util.ArrayList;
import java.util.Scanner;

public class Field {

    // Стек, который запоминает поля предыдущих ходов.
    // StackByValue stackOfMoves;

    // Игровое поле.
    Cell[][] field;

    // Массив возможных ходов.
    Cell[][] fieldPossible;

    // Лист пар координат, на которые будет производиться ход.
    ArrayList<PairsOfCoordinates> coordinatesOfMove;

    Field() {
        //stackOfMoves = new StackByValue();
        field = new Cell[8][8];
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                field[i][j] = new Cell('_');
            }
        }

        field[3][3] = new Cell('●');
        field[4][4] = new Cell('●');
        field[4][3] = new Cell('◯');
        field[3][4] = new Cell('◯');
    }

    // Класс клетка внутри поля.
    class Cell {
        char condition;

        Cell(char color) {
            condition = color;
        }

    }


    // Метод для создания массива с координатами клеток другого цвета вокруг заданной.
    ArrayList<PairsOfCoordinates> createListOfCoordinates(int x, int y, char color) {
        ArrayList<PairsOfCoordinates> coordinates = new ArrayList<PairsOfCoordinates>();
        // Проверяем углы поля (4), так как они отличаются от остальных тем, что не имеют вокруг себя 5 позиций.

        if (x == 0 && y == 0) {
            if (field[1][0].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 1, 0));
            if (field[0][1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 0, 1));
            if (field[1][1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 1, 1));
        } else if (x == 0 && y == 7) {

            if (field[1][7].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 1, 7));
            if (field[0][6].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 0, 6));
            if (field[1][6].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 1, 6));
        } else if (x == 7 && y == 0) {

            if (field[6][0].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 6, 0));
            if (field[6][1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 6, 1));
            if (field[7][1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 7, 1));
        } else if (x == 7 && y == 7) {

            if (field[6][7].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 6, 7));
            if (field[6][6].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 6, 6));
            if (field[7][6].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, 7, 6));

            // Проверяем стороны поля (4), так как они отличаются от остальных тем, что не имеют вокруг себя 3 позиций.

        } else if (x == 0) {
            if (field[x][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y - 1));
            if (field[x + 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y));
            if (field[x][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y + 1));
            if (field[x + 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y - 1));
            if (field[x + 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y + 1));

        } else if (y == 0) {
            if (field[x - 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y));
            if (field[x][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y + 1));
            if (field[x + 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y));
            if (field[x - 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y + 1));
            if (field[x + 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y + 1));


        } else if (x == 7) {
            if (field[x][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y + 1));
            if (field[x - 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y));
            if (field[x][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y - 1));
            if (field[x - 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y - 1));
            if (field[x - 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y + 1));


        } else if (y == 7) {
            if (field[x - 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y));
            if (field[x][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y - 1));
            if (field[x + 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y));
            if (field[x - 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y - 1));
            if (field[x + 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y - 1));


            // Проверяем остальные клетки, у которых исключений нет.

        } else {
            if (field[x][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y - 1));
            if (field[x - 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y));
            if (field[x][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x, y + 1));
            if (field[x + 1][y].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y));
            if (field[x - 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y - 1));
            if (field[x - 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x - 1, y + 1));
            if (field[x + 1][y + 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y + 1));
            if (field[x + 1][y - 1].condition == oppositeColor(color))
                coordinates.add(new PairsOfCoordinates(x, y, x + 1, y - 1));

        }
        return coordinates;
    }


    // Метод для заполнения массива координат возможных ходов.
    void createListOfMove(char color) {
        coordinatesOfMove = new ArrayList<PairsOfCoordinates>();
        // Проходимся по каждой клетке поля
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                if (field[i][j].condition == color) {
                    // Создаём лист пар координат.
                    ArrayList<PairsOfCoordinates> coordinates;
                    coordinates = createListOfCoordinates(i, j, color);

                    // Проверяем массив на пустоту.
                    if (!coordinates.isEmpty()) {

                        for (var k = 0; k < coordinates.size(); k++) {
                            int a = coordinates.get(k).x2;
                            int b = coordinates.get(k).y2;
                            int x = coordinates.get(k).x2;
                            int y = coordinates.get(k).y2;
                            if (x == i) {
                                if (y == j + 1) {
                                    moveForwardHorizontalSecond(a, b, x, y, color);

                                } else {
                                    moveBackwardHorizontalSecond(a, b, x, y, color);
                                }
                            } else if (y == j) {
                                if (x == i + 1) {
                                    moveForwardVerticalFirst(a, b, x, y, color);
                                } else {
                                    moveBackwardVerticalFirst(a, b, x, y, color);
                                }
                            } else if (x == i - 1 && y == j - 1) {
                                moveBackwardDiagonalFromLeftToRight(a, b, x, y, color);
                            } else if (x == i + 1 && y == j + 1) {
                                moveForwardDiagonalFromLeftToRight(a, b, x, y, color);

                            } else if (x == i - 1 && y == j + 1) {
                                moveForwardDiagonalFromRightToLeft(a, b, x, y, color);

                            } else if (x == i + 1 && y == j - 1) {
                                moveBackwardDiagonalFromRightToLeft(a, b, x, y, color);

                            }
                        }
                    }

                }
            }
        }
    }

    // Метод для создания массива с возможными ходами, которые при выводе будут отмечены пунктиром.
    void createArrayWithPossibleMove() {
        fieldPossible = new Cell[8][8];
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                fieldPossible[i][j] = new Cell('_');
            }
        }
        for (var i = 0; i < coordinatesOfMove.size(); i++) {
            int x = coordinatesOfMove.get(i).x2;
            int y = coordinatesOfMove.get(i).y2;
            if (fieldPossible[x][y].condition == '_')
                fieldPossible[x][y] = new Cell('◌');
        }
    }

    // Метод для вывода поля.
    void printField(char color) {
        createListOfMove(color);
        createArrayWithPossibleMove();

        System.out.print("  ");
        for (var i = 1; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (var i = 0; i < 8; i++) {
            int a = i + 1;
            System.out.print(a + " ");
            for (var j = 0; j < 8; j++) {
                if (fieldPossible[i][j].condition == '◌')
                    System.out.print(fieldPossible[i][j].condition + " ");
                else
                    System.out.print(field[i][j].condition + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    // Метод для заполнения поля.
    void changeField(int choice, char color) {
        // Тут также применялся способ через два for`a, однако результат тотже.
        Cell[][] fieldCopy = new Cell[8][8];
        for (var i = 0; i < 8; i++) {
            fieldCopy[i] = field[i].clone();
        }
        // stackOfMoves.add(fieldCopy);
        ArrayList<PairsOfCoordinates> filledCells = new ArrayList<PairsOfCoordinates>();
        int x = choice / 10;
        int y = choice % 10;
        for (var i = 0; i < coordinatesOfMove.size(); i++) {
            if (coordinatesOfMove.get(i).x2 == x && coordinatesOfMove.get(i).y2 == y) {
                filledCells.add(new PairsOfCoordinates(coordinatesOfMove.get(i).x1, coordinatesOfMove.get(i).y1, x, y));
            }
        }

        for (var i = 0; i < filledCells.size(); i++) {
            int x1 = filledCells.get(i).x1;
            int y1 = filledCells.get(i).y1;
            int x2 = filledCells.get(i).x2;
            int y2 = filledCells.get(i).y2;

            if (x1 == x2) {
                if (y2 > y1) {
                    for (var j = y1; j <= y2; j++) {
                        changeCellColor(x1, j, color);
                    }
                } else {
                    for (var j = y2; j <= y1; j++) {
                        changeCellColor(x1, j, color);
                    }
                }
            } else if (y1 == y2) {
                if (x2 > x1) {
                    for (var j = x1; j <= x2; j++) {
                        changeCellColor(j, y1, color);
                    }
                } else {
                    for (var j = x2; j <= x1; j++) {
                        changeCellColor(j, y1, color);
                    }
                }
            } else {
                if (x1 - x2 > 0) {
                    if (y1 - y2 > 0) {
                        var k = y1;
                        for (var j = x1; j >= x2; j--) {
                            changeCellColor(j, k, color);
                            k--;
                        }
                    } else {
                        var k = y1;
                        for (var j = x1; j >= x2; j--) {
                            changeCellColor(j, k, color);
                            k++;
                        }
                    }
                } else {
                    if (y1 - y2 > 0) {
                        var k = y1;
                        for (var j = x1; j <= x2; j++) {
                            changeCellColor(j, k, color);
                            k--;
                        }
                    } else {
                        var k = y1;
                        for (var j = x1; j <= x2; j++) {
                            changeCellColor(j, k, color);
                            k++;
                        }
                    }
                }
            }
        }
    }

    // Метод заполнения поля по формуле бота.
    public void createArrayOfGradesNewbie() {
        createListOfMove('◯');
        int length = 0;
        int func;
        int max = -1;
        int x2M = 0;
        int y2M = 0;
        for (var i = 0; i < coordinatesOfMove.size(); i++) {
            int x1 = coordinatesOfMove.get(i).x1;
            int y1 = coordinatesOfMove.get(i).y1;
            int x2 = coordinatesOfMove.get(i).x2;
            int y2 = coordinatesOfMove.get(i).y2;
            if (x1 == x2)
                length = Math.abs(y2 - y1) + 1;
            else
                length = Math.abs(x2 - x1) + 1;
            func = length;
            if (x1 == x2) {
                if (x1 == 0 || x1 == 7) {
                    func += 1.4 * length;
                }
                if (x2 == 0 && y2 == 0) {
                    func += 0.4;
                }
                if (x2 == 0 && y2 == 7) {
                    func += 0.4;
                }
                if (x2 == 7 && y2 == 0) {
                    func += 0.4;
                }
                if (x2 == 7 && y2 == 7) {
                    func += 0.4;
                }
            } else if (y1 == y2) {
                if (y1 == 0 || y1 == 7) {
                    func += 1.4 * length;
                }
                if (x2 == 0 && y2 == 0) {
                    func += 0.4;
                }
                if (x2 == 0 && y2 == 7) {
                    func += 0.4;
                }
                if (x2 == 7 && y2 == 0) {
                    func += 0.4;
                }
                if (x2 == 7 && y2 == 7) {
                    func += 0.4;
                }
            } else {
                if (x2 == 0 && y2 == 0) {
                    func += 1.8;
                }
                if (x2 == 0 && y2 == 7) {
                    func += 1.8;
                }
                if (x2 == 7 && y2 == 0) {
                    func += 1.8;
                }
                if (x2 == 7 && y2 == 7) {
                    func += 1.8;
                }
            }
            if (func > max) {
                max = func;
                x2M = x2;
                y2M = y2;
            }
        }
        int sum = x2M * 10 + y2M;
        changeField(sum, '◯');
    }


    // Метод для ввода координат пользователем.
    int scanInt() {
        if (coordinatesOfMove.isEmpty()) {
            return -1;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пару цифр без пробела." +
                "\nСначала координата, которая указана по вертикали," +
                "\nЗатем по горизонтали." +
                "\nВыбрать можно только ту клетку, которая отмечена пунктирным кружком.\n");
        int choice;
        boolean flag = false;
        int k = 0;
        do {
            if (k > 0) {
                System.out.println("Вы ввели недопустимую пару цифр." +
                        "\nПопробуйте ещё раз:\n");
            }
            choice = in.nextInt();
            int x = choice / 10 - 1;
            int y = choice % 10 - 1;
            for (var i = 0; i < coordinatesOfMove.size(); i++) {
                if (coordinatesOfMove.get(i).x2 == x && coordinatesOfMove.get(i).y2 == y)
                    flag = true;
            }
            k++;
        } while (!flag);
        return choice;
    }


    // Метод для окраса клетки.
    void changeCellColor(int x, int y, char color) {
        if (color == '●') {
            field[x][y].condition = '●';
        } else {
            field[x][y].condition = '◯';
        }
    }

    // Метод для нахождения обратного цвета клетки. Пустая остаётся пустой.
    char oppositeColor(char color) {
        if (color == '●')
            return '◯';
        else if (color == '_')
            return '_';
        else
            return '●';

    }

    // Метод для определения, заполнено ли поле полностью.
    public boolean checkFull() {
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                if (field[i][j].condition == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    // Метод для определения, есть ли на поле оба цвета, иначе - проигрыш.
    boolean checkOneColor() {
        int count1 = 0;
        int count2 = 0;
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                if (field[i][j].condition == '◯')
                    count1++;
                else if (field[i][j].condition == '●')
                    count2++;
            }
        }
        if (count1 == 0 || count2 == 0)
            return false;
        return true;
    }

    // Метод для посчитывания очков первого игрока.
    int countOfFirstPlayer() {
        int count = 0;
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                if (field[i][j].condition == '●')
                    count++;
            }
        }
        return count;
    }

    // Метод для посчитывания очков второго игрока.
    int countOfSecondPlayer() {
        int count = 0;
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                if (field[i][j].condition == '◯')
                    count++;
            }
        }
        return count;
    }

    // Методы для нахождения координаты первой точки, от которой нужно идти, чтобы перекрасить клетку, до второй координаты.

    // Метод прохождения по полю вперёд горизонтально. (Изменение второй координаты)
    void moveForwardHorizontalSecond(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && second < 7) {
            second++;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю назад горизонтально. (Изменение второй координаты)
    void moveBackwardHorizontalSecond(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && second > 0) {
            second--;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю вперёд вертикально. (Изменение первой координаты)
    void moveForwardVerticalFirst(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first < 7) {
            first++;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю назад вертикально. (Изменение первой координаты)
    void moveBackwardVerticalFirst(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first > 0) {
            first--;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю вперед диагонально (диагональ слева направо).
    void moveForwardDiagonalFromLeftToRight(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first < 7 && second < 7) {
            first++;
            second++;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю назад диагонально (диагональ слева направо).

    void moveBackwardDiagonalFromLeftToRight(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first > 0 && second > 0) {
            first--;
            second--;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю вперед диагонально (диагональ справа налево).

    void moveForwardDiagonalFromRightToLeft(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first > 0 && second < 7) {
            first--;
            second++;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

    // Метод прохождения по полю назад диагонально (диагональ справа налево).

    void moveBackwardDiagonalFromRightToLeft(int start, int finish, int first, int second, char color) {
        boolean isCellOpposite = true;
        while (field[first][second].condition == oppositeColor(color) && first < 7 && second > 0) {
            first++;
            second--;
            if (field[first][second].condition == color) {
                isCellOpposite = false;
                break;
            }
            if (field[first][second].condition == '_')
                break;
        }
        if (isCellOpposite && field[first][second].condition == '_') {
            coordinatesOfMove.add(new PairsOfCoordinates(start, finish, first, second));
        }
    }

}



