import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

// Класс, который работает с файлами, извлекая их из всех поддиректорий.
public class FilesExtractor {

    // Метод, который осуществляет это.
    public static List<Path> createListOfFiles(Path path) throws IOException {
        Deque<Path> stackOfDirectories = new ArrayDeque<Path>();
        List<Path> listOfFiles = new LinkedList<>();
        stackOfDirectories.push(path);
        while (!stackOfDirectories.isEmpty()) {
            DirectoryStream<Path> stream = Files.newDirectoryStream(stackOfDirectories.pop());
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    stackOfDirectories.push(entry);
                } else {
                    listOfFiles.add(entry);
                }
            }
            stream.close();
        }
        return listOfFiles;
    }

    // Метод, разгружающий main, который запрашивает у user директорию.
    public static String getCurrDirectory() {
        System.out.println("Print directory or skip:");
        Scanner scanner = new Scanner(System.in);
        String currDirectory = scanner.nextLine();
        if (currDirectory.isEmpty()) {
            currDirectory = System.getProperty("user.dir");
        }
        return currDirectory;
    }

}
