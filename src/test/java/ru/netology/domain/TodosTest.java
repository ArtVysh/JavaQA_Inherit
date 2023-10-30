package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTitleFromSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(54, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpic() {

        String[] subtasks = {"Шиномонтаж", "Мойка", "Замена масла"};
        Epic epic = new Epic(12, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Мойка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindNotQueryInEpic() {

        String[] subtasks = {"Шиномонтаж", "Мойка", "Замена масла"};
        Epic epic = new Epic(12, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Магазин");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testShouldFindQueryInMeetingInTopic() {
        Meeting meeting = new Meeting(
                23,
                "Актуализация проектной документации",
                "АСУТП компрессорной станции",
                "01.12.2023"
        );

        boolean expected = true;
        boolean actual = meeting.matches("документации");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldFindQueryInMeetingInProject() {
        Meeting meeting = new Meeting(
                23,
                "Актуализация проектной документации",
                "АСУТП компрессорной станции",
                "01.12.2023"
        );

        boolean expected = true;
        boolean actual = meeting.matches("АСУТП");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldNotFindQueryInMeeting() {
        Meeting meeting = new Meeting(
                23,
                "Актуализация проектной документации",
                "АСУТП компрессорной станции",
                "01.12.2023"
        );

        boolean expected = false;
        boolean actual = meeting.matches("поверка КИП");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldSearchDifferentType() {
        Meeting meeting = new Meeting(
                23,
                "Актуализация проектной документации",
                "АСУТП компрессорной станции",
                "01.12.2023"
        );

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTasks() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Записаться к врачу");
        SimpleTask simpleTask3 = new SimpleTask(7, "Позвонить ветеринару");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask1, simpleTask3};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindAnythingTasks() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Записаться к врачу");
        SimpleTask simpleTask3 = new SimpleTask(7, "Оплатить стоянку");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("Привезти");

        Assertions.assertArrayEquals(expected, actual);

    }
}
