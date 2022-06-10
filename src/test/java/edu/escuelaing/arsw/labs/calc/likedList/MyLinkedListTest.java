package edu.escuelaing.arsw.labs.calc.likedList;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.escuelaing.arsw.labs.calc.UtilsForTests;
import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;

public class MyLinkedListTest {

    @Test
    public void addAndGetTest() {
        boolean isCorrect = true;
        MyLinkedList<Number> linkedList = new MyLinkedList<>();
        Number first = 1;
        Number second = 2;
        Number last = 3;
        linkedList.add(second);
        linkedList.addFirst(first);
        linkedList.addLast(last);
        isCorrect = isCorrect && (linkedList.size() == 3);
        isCorrect = isCorrect && (linkedList.getFirst() == first);
        isCorrect = isCorrect && (linkedList.getLast() == last);
        assertTrue(isCorrect);
    }

    @Test
    public void removeTest() {
        boolean isCorrect = true;
        MyLinkedList<Number> linkedList = new MyLinkedList<>();
        Number first = 1;
        Number second = 2;
        Number last = 3;
        linkedList.add(second);
        linkedList.addFirst(first);
        linkedList.addLast(last);
        isCorrect = isCorrect && (linkedList.removeFirst() == first);
        isCorrect = isCorrect && (linkedList.size() == 2);
        isCorrect = isCorrect && (linkedList.removeLast() == last);
        isCorrect = isCorrect && (linkedList.size() == 1);
        assertTrue(isCorrect);
    }

    @Test
    public void initTest() {
        MyLinkedList<Number> data1 = new MyLinkedList<>(UtilsForTests.getData1());
        MyLinkedList<Number> data1Prior = new MyLinkedList<>(UtilsForTests.getData1Prior());
        boolean isCorrect = true;
        for (int i = 0; i < UtilsForTests.sizeData1; i++) {
            isCorrect = isCorrect && (data1.poll().doubleValue() == data1Prior.pop().doubleValue());
            isCorrect = isCorrect && (data1.size() == UtilsForTests.sizeData1 - (i + 1));
            isCorrect = isCorrect && (data1Prior.size() == UtilsForTests.sizeData1 - (i + 1));
        }
        assertTrue(isCorrect);
    }

}
