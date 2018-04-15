package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huy.huynh on 16/01/2018.
 */
public class FileUtils {

    public static String readTextFile(Class classLoader, String fileName) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(
                    Paths.get(classLoader.getResource(classLoader.getSimpleName() + "\\" + fileName).toURI()).toFile()
                            .toPath()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void writeToTextFile(ClassLoader classLoader, String fileName, String content) {
        try {
            Files.write(Paths.get(classLoader.getResource(fileName).toURI()).toFile().toPath(), content.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
//    public String getFile(String fileName) {
//
//        StringBuilder result = new StringBuilder("");
//
//        //Get file from resources folder
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//
//        try (Scanner scanner = new Scanner(file)) {
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                result.append(line).append("\n");
//            }
//
//            scanner.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return result.toString();
//
//    }
//
//    public static List<String> readTextFileByLines(String fileName) {
//        List<String> lines = null;
//        try {
//            lines = Files.readAllLines(Paths.get(fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }
}
