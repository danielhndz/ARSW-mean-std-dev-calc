package edu.escuelaing.arsw.labs.calc;

import java.io.IOException;
import java.nio.file.Path;

import edu.escuelaing.arsw.labs.calc.linkedList.Node;

public class UtilsForTests {

    private static final String data1FileName = "data1.txt";
    private static final String data2FileName = "data2.txt";
    private static final String dir = "src/test/res";

    private static Node<Number> data1 = null;
    private static Node<Number> data1Prior = null;
    private static Node<Number> data1Rev = null;
    public static int sizeData1 = 10;

    private static Node<Number> data2 = null;
    private static Node<Number> data2Prior = null;
    private static Node<Number> data2Rev = null;
    public static int sizeData2 = 10;

    public static Node<Number> getData1() {
        if (data1 != null) {
            return data1;
        } else {
            try {
                return fromFile(data1FileName, false, false);
            } catch (IOException e) {
                return defaultData(data1FileName, false, false);
            }
        }
    }

    public static Node<Number> getData1Prior() {
        if (data1Prior != null) {
            return data1Prior;
        } else {
            try {
                return fromFile(data1FileName, true, false);
            } catch (IOException e) {
                return defaultData(data1FileName, true, false);
            }
        }
    }

    public static Node<Number> getData1Rev() {
        if (data1Rev != null) {
            return data1Rev;
        } else {
            try {
                return fromFile(data1FileName, false, true);
            } catch (IOException e) {
                return defaultData(data1FileName, false, true);
            }
        }
    }

    public static Node<Number> getData2() {
        if (data2 != null) {
            return data2;
        } else {
            try {
                return fromFile(data2FileName, false, false);
            } catch (IOException e) {
                return defaultData(data2FileName, false, false);
            }
        }
    }

    public static Node<Number> getData2Prior() {
        if (data2Prior != null) {
            return data2Prior;
        } else {
            try {
                return fromFile(data2FileName, true, false);
            } catch (IOException e) {
                return defaultData(data2FileName, true, false);
            }
        }
    }

    public static Node<Number> getData2Rev() {
        if (data2Rev != null) {
            return data2Rev;
        } else {
            try {
                return fromFile(data2FileName, false, true);
            } catch (IOException e) {
                return defaultData(data2FileName, false, true);
            }
        }
    }

    private static Node<Number> fromFile(String name, boolean prior, boolean rev) throws IOException {
        return Tools.nodeFromFile(
                Path.of("", dir.replace("/", System.getProperty("file.separator"))),
                name, prior, rev);
    }

    private static Node<Number> defaultData(String name, boolean prior, boolean rev) {
        Node<Number> head = null, currentNode;
        switch (name) {
            case "data1.txt":
                if (rev) {
                    currentNode = new Node<>(1503);
                    currentNode.setNext(new Node<Number>(624));
                    head = currentNode;
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(1657));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(128));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(270));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(230));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(229));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(114));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(591));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(160));
                    break;
                } else if (prior) {
                    currentNode = new Node<>(160);
                    currentNode.setPrior(new Node<Number>(591));
                    head = currentNode;
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(114));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(229));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(230));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(270));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(128));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(1657));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(624));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(1503));
                } else {
                    currentNode = new Node<>(160);
                    currentNode.setNext(new Node<Number>(591));
                    head = currentNode;
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(114));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(229));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(230));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(270));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(128));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(1657));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(624));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(1503));
                }
                break;
            case "data2.txt":
                if (rev) {
                    currentNode = new Node<>(138.2);
                    currentNode.setNext(new Node<Number>(38.8));
                    head = currentNode;
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(198.7));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(19.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(65.9));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(28.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(22.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(6.5));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(69.9));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(15));
                } else if (prior) {
                    currentNode = new Node<>(15);
                    currentNode.setPrior(new Node<Number>(69.9));
                    head = currentNode;
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(6.5));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(22.4));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(28.4));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(65.9));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(19.4));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(198.7));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(38.8));
                    currentNode = currentNode.getPrior();
                    currentNode.setPrior(new Node<Number>(138.2));
                } else {
                    currentNode = new Node<>(15);
                    currentNode.setNext(new Node<Number>(69.9));
                    head = currentNode;
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(6.5));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(22.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(28.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(65.9));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(19.4));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(198.7));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(38.8));
                    currentNode = currentNode.getNext();
                    currentNode.setNext(new Node<Number>(138.2));
                }
                break;
        }
        return head;
    }
}
