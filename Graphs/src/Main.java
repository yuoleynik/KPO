import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String currDirectory = FilesExtractor.getCurrDirectory();
        Path path = Paths.get(currDirectory);

        GraphConstructor constructor = new GraphConstructor(currDirectory);

        var listOfFiles = FilesExtractor.createListOfFiles(path);
        constructor.buildGraph(listOfFiles);
        var sortedList = constructor.getSortList();

        for (var file : sortedList) {
            System.out.println(file.getFileName());
        }

        constructor.concatenateFilesToOneFile();
    }
}