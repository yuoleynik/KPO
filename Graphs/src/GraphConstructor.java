import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.readAllLines;

// Класс, работающий с графом.
public class GraphConstructor {

    // Директория, с которой происходит работа.
    String сurrDirectory;

    // Map с ключом - путём до файла и значением - листом его зависимостей.
    Map<Path, List<Path>> mapOfPaths;

    // Отсортированный список зависимостей.
    List<Path> listOfSortedFiles;

    // Map для работы с алгоритмом DFS.
    Map<Path, Integer> mapOfColors;

    // Конструктор.
    public GraphConstructor(String currDirectory) {
        mapOfPaths = new HashMap<>();
        listOfSortedFiles = new ArrayList<>();
        mapOfColors = new HashMap<>();
        this.сurrDirectory = currDirectory;
    }

    // Построение зависимостей графа.
    public void buildGraph(List<Path> listOfFiles) throws IOException {
        for (var file : listOfFiles) {
            List<Path> listOfLinks = new ArrayList<>();
            List<String> temp = readAllLines(file);
            for (var line : temp) {
                if (line.startsWith("require")) {
                    var newPath = line.split("'");
                    if (newPath.length == 2) {

                        // Для случаев, если после require невалидный путь до файла.
                        if (exists(Paths.get(сurrDirectory + "/" + newPath[1])))
                            listOfLinks.add(Paths.get(сurrDirectory + "/" + newPath[1]));
                    } else {
                        System.out.println("Path " + line + " isn`t correct");
                    }
                }
            }
            mapOfPaths.put(file, listOfLinks);
            mapOfColors.put(file, 0);
        }
    }

    // Алгоритм DFS.
    private void algorithmDfs(Path path) {
        if (mapOfColors.get(path) == 1) {
            System.out.println("Oops, files cycled." +
                    "");
            System.out.println("Last seen file: " + path);
            System.exit(0);
        } else {
            if (mapOfColors.get(path) == 2) {
                return;
            }
            mapOfColors.replace(path, 1);
            for (var i = 0; i < mapOfPaths.get(path).size(); i++) {
                algorithmDfs(mapOfPaths.get(path).get(i));
            }
            listOfSortedFiles.add(path);
            mapOfColors.replace(path, 2);
        }
    }

    // Заполняем сортированный лист.
    public List<Path> getSortList() {
        for (var path : mapOfPaths.keySet()) {
            if (mapOfColors.get(path) == 0)
                algorithmDfs(path);
        }
        return listOfSortedFiles;
    }

    // Конкатенация файлов.
    public void concatenateFilesToOneFile() throws IOException {
        PrintWriter writer = new PrintWriter("Concatenated.txt");
        for (var file : listOfSortedFiles) {
            var listOfLines = Files.readAllLines(file);
            for (var line : listOfLines)
                writer.println(line);
        }
        writer.close();
    }

}
