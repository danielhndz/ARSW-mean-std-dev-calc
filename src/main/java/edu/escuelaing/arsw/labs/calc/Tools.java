package edu.escuelaing.arsw.labs.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import edu.escuelaing.arsw.labs.calc.linkedList.Node;

public class Tools {

    public static Node<Number> nodeFromFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Node<Number> prevNode = null;
        Node<Number> head = null;
        Node<Number> currentNode;
        for (String line : lines) {
            if (StringUtils.isNumeric(line.replace("-", "").replace(".", ""))) {
                if (prevNode == null) {
                    prevNode = new Node<>(Double.parseDouble(line));
                    head = prevNode;
                } else {
                    currentNode = new Node<Number>(Double.parseDouble(line));
                    prevNode.setNext(currentNode);
                    prevNode = currentNode;
                }
            }
        }
        return head;
    }

    public static Node<Number> nodeFromFile(Path path, String name, boolean prior, boolean rev) throws IOException {
        List<String> lines = Files.readAllLines(path.resolve(name));
        if (rev) {
            lines = Lists.reverse(Files.readAllLines(path.resolve(name)));
        }
        Node<Number> prevNode = null;
        Node<Number> head = null;
        Node<Number> currentNode;
        for (String line : lines) {
            if (StringUtils.isNumeric(line.replace("-", "").replace(".", ""))) {
                if (prior) {
                    if (prevNode == null) {
                        prevNode = new Node<>(Double.parseDouble(line));
                        head = prevNode;
                    } else {
                        currentNode = new Node<Number>(Double.parseDouble(line));
                        prevNode.setPrior(currentNode);
                        prevNode = currentNode;
                    }
                } else {
                    if (prevNode == null) {
                        prevNode = new Node<>(Double.parseDouble(line));
                        head = prevNode;
                    } else {
                        currentNode = new Node<Number>(Double.parseDouble(line));
                        prevNode.setNext(currentNode);
                        prevNode = currentNode;
                    }
                }
            }
        }
        return head;
    }
}
