package edu.escuelaing.arsw.labs.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;

/**
 * Administra la app
 * 
 */
public class App {
    public static void main(String[] args) {
        computeStats(args[0]);
    }

    private static void computeStats(String fileName) {
        List<Path> paths = findPathsByFileName(fileName);
        MyLinkedList<Number> linkedList;
        for (Path path : paths) {
            System.out.println("File : " + path);
            try {
                linkedList = new MyLinkedList<>(Tools.nodeFromFile(path));
                System.out.println("mean : " + Stats.mean(linkedList));
                System.out.println("stdDev : " + Stats.stdDev(linkedList));
            } catch (IOException e) {
                System.err.println("Error al leer el archivo.");
            }
        }
    }

    private static List<Path> findPathsByFileName(String fileName) {
        List<Path> paths;
        Path path = Paths.get(System.getProperty("user.home"));
        try (Stream<Path> pathStream = Files.find(
                path,
                Integer.MAX_VALUE,
                (p, BasicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName))) {
            paths = pathStream.collect(Collectors.toList());
            return paths;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
