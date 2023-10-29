package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TaskTest {

    @Test
    public void testShouldFind() {
        Task task = new SimpleTask(4, "Купить молоко");
        boolean expected = true;
        boolean actual = task.matches("Купи");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldNotFind() {
        Task task = new SimpleTask(4, "Забрать посылку");

        boolean expected = false;
        boolean actual = task.matches("Купи");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldNotFindInTask() {
        Task task = new Task(4);

        boolean expected = false;
        boolean actual = task.matches("Встреча");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldGetIdInTask() {
        Task task = new Task(98);

        int expected = 98;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldEqualsTask() {

        SimpleTask simpleTask1 = new SimpleTask(512, "Купить молока");
        SimpleTask simpleTask2 = new SimpleTask(512, "Купить молока");

        boolean expected = true;
        boolean actual = simpleTask1.equals(simpleTask2);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testShouldNotEqualsTask() {

        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить молока");

        boolean expected = false;
        boolean actual = simpleTask1.equals(simpleTask2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHash() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        int expected = 36;
        int actual = simpleTask.hashCode();
        Assertions.assertEquals(expected, actual);
    }


}
