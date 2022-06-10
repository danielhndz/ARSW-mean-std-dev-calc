package edu.escuelaing.arsw.labs.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.escuelaing.arsw.labs.calc.linkedList.MyLinkedList;

public class StatsTest {

    @Test
    public void mean() {
        assertEquals(550.6, Stats.mean(new MyLinkedList<>(UtilsForTests.getData1())), 0.01);
        assertEquals(60.32, Stats.mean(new MyLinkedList<>(UtilsForTests.getData2())), 0.01);
    }

    @Test
    public void stdDev() {
        assertEquals(572.03, Stats.stdDev(new MyLinkedList<>(UtilsForTests.getData1())), 0.01);
        assertEquals(62.26, Stats.stdDev(new MyLinkedList<>(UtilsForTests.getData2())), 0.01);
    }
}
