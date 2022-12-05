import java.util.ArrayList;

// Везде, где используется данный класс, строки кода закомментированы, чтобы не сломать программу.

public class StackByValue {

    // Лист, где храним поля.
    ArrayList<Field.Cell[][]> stack;
    StackByValue() {
        stack = new ArrayList<>();
    }

    // Метод добавления поля в лист.
    void add(Field.Cell[][] field) {
        stack.add(field);
    }

    // Метод pop, как у стека: забираем верхнее поле и удаляем его, при этом его возвращая.
    Field.Cell[][] pop() {
        Field.Cell[][] fieldCopy = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return fieldCopy;
    }

    // Метод top, как у стека: возвращаем верхнее поле.
    Field.Cell[][] top() {
        return stack.get(stack.size()-1);
    }

}
