package edu.escuelaing.arsw.labs.calc.iterator;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import edu.escuelaing.arsw.labs.calc.UtilsForTests;
import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;

public class MyIteratorTest {

    @Test
    public void iterateData1() {
        assertTrue(
                iterateTraversalAndReversal(
                        new MyLinkedList<>(UtilsForTests.getData1()),
                        new MyLinkedList<>(UtilsForTests.getData1Rev())));
    }

    @Test
    public void iterateData2() {
        assertTrue(
                iterateTraversalAndReversal(
                        new MyLinkedList<>(UtilsForTests.getData2()),
                        new MyLinkedList<>(UtilsForTests.getData2Rev())));
    }

    private boolean iterateTraversalAndReversal(MyLinkedList<Number> linkedList, MyLinkedList<Number> linkedListRev) {
        boolean isCorrect = true;
        Iterator<Number> descendingIterator = linkedListRev.descendingIterator();
        while (descendingIterator.hasNext()) {
            isCorrect = isCorrect && (descendingIterator.next().doubleValue() == linkedList.pop().doubleValue());
        }
        return isCorrect;
    }
}
