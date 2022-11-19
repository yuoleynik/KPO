import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    String presence;
    int grade;

    public Student(String name) {
        this.name = name;
        presence = "Не отмечен(а)";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Student> listOfStudents = Arrays.asList(new Student("Name1"), new Student("Name2"),
                new Student("Name3"), new Student("Name4"), new Student("Name5"));
        String choice;
        do {
            System.out.println("Если нужна помощь, то введите '/h'.\n" +
                    "Чтобы выйти в любой момент введите 'q'\n");

            choice = in.nextLine();
            if (choice.equals("/h")) {
                System.out.println("1. /r - choose random student\n" +
                        "2. /l - list of student with grades\n");
                choice = in.nextLine();
            }
            if (choice.equals("/r")) {
                int num1 = (int) (Math.random() * 5);
                while (!(listOfStudents.get(num1)).presence.equals("Не отмечен(а)")) {
                    num1 = (int) (Math.random() * 5);
                }
                String res = String.format("Отвечает Студент %s.\n" +
                        "Присутствует ли на паре? \nВведите(y/n):\n", (listOfStudents.get(num1)).name);
                System.out.println(res);
                choice = in.nextLine();
                if (choice.equals("y")) {
                    (listOfStudents.get(num1)).presence = "Присутствует";
                    System.out.println("Оценка за ответ:\n");
                    int choiceInt = in.nextInt();
                    (listOfStudents.get(num1)).grade = choiceInt;
                } else {
                    (listOfStudents.get(num1)).presence = "Отсутствует";
                }
            } else if (choice.equals("/l")) {
                for (var i = 0; i < listOfStudents.size(); i++) {
                    System.out.println(String.format("%s %d %s\n", (listOfStudents.get(i)).name, (listOfStudents.get(i)).grade, (listOfStudents.get(i)).presence));
                }
            }
        } while (!choice.equals("q"));
    }
}