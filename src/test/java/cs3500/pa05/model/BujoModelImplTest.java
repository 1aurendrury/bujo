package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BujoModelImplTest {
  BujoModelImpl bujo1;
  BujoModelImpl bujo2;
  Theme sampleTheme1;
  Theme sampleTheme2;
  Task task1;
  Task task2;
  Task task3;
  Task task4;
  Task task5;
  Task task6;
  Task task7;
  Event event1;
  Event event2;
  Event event3;
  Event event4;
  Event event5;
  Event event6;
  Event event7;

  @BeforeEach
  void setup() {
    bujo1 = new BujoModelImpl();
    bujo2 = new BujoModelImpl();
    sampleTheme1 = new Theme("Sample theme", Color.BLUE, "Arial", null);
    sampleTheme2 = new Theme("Other sample theme", Color.RED, "Comic sans", null);
    task1 = new Task("task1", "this is task 1", "monday", false);
    task2 = new Task("task2", "this is task 2", "tuesday", false);
    task3 = new Task("task3", "this is task 3", "wednesday", false);
    task4 = new Task("task4", "this is task 4", "thursday", false);
    task5 = new Task("task5", "this is task 5", "friday", false);
    task6 = new Task("task6", "this is task 6", "saturday", false);
    task7 = new Task("task7", "this is task 7", "sunday", false);

    event1 = new Event("event1", "this is event 1", "Monday", 12, 1);
    event2 = new Event("event2", "this is event 2", "Tuesday", 13, 2);
    event3 = new Event("event3", "this is event 3", "Wednesday", 15, 3);
    event4 = new Event("event4", "this is event 4", "Thurday", 18, 4);
    event5 = new Event("event5", "this is event 5", "Friday", 18, 4);
    event6 = new Event("event6", "this is event 6", "Saturday", 18, 4);
    event7 = new Event("event7", "this is event 7", "Sunday", 18, 4);
  }

  @Test
  void testChangeTheme() {
    assertNull(bujo1.theme);
    assertNull(bujo2.theme);

    bujo1.changeTheme(sampleTheme1);
    bujo2.changeTheme(sampleTheme2);

    assertEquals(sampleTheme1, bujo1.theme);
    assertEquals(sampleTheme2, bujo2.theme);
  }

  @Test
  void testAddTask() {
    assertEquals(0, bujo1.allTasks.size());
    bujo1.addTask(task1, "monday");
    assertEquals(1, bujo1.allTasks.size());
    bujo1.addTask(task2, "tuesday");
    assertEquals(2, bujo1.allTasks.size());
    bujo1.addTask(task3, "wednesday");
    assertEquals(3, bujo1.allTasks.size());
    bujo1.addTask(task4, "thursday");
    assertEquals(4, bujo1.allTasks.size());

    assertEquals(0, bujo2.allTasks.size());
    bujo2.addTask(task5, "friday");
    assertEquals(1, bujo2.allTasks.size());
    bujo2.addTask(task6, "Saturday");
    assertEquals(2, bujo2.allTasks.size());
    bujo2.addTask(task7, "SUNDAY");
    assertEquals(3, bujo2.allTasks.size());

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      bujo1.addTask(task1, "invalidDay");
    });
  }

  @Test
  void testAddEvent() {
    assertEquals(0, bujo1.allEvents.size());
    bujo1.addEvent(event1, "monday");
    assertEquals(1, bujo1.allEvents.size());
    bujo1.addEvent(event2, "tuesday");
    assertEquals(2, bujo1.allEvents.size());
    bujo1.addEvent(event3, "Wednesday");
    assertEquals(3, bujo1.allEvents.size());
    bujo1.addEvent(event4, "Thursday");
    assertEquals(4, bujo1.allEvents.size());

    assertEquals(0, bujo2.allEvents.size());
    bujo2.addEvent(event5, "friday");
    assertEquals(1, bujo2.allEvents.size());
    bujo2.addEvent(event6, "SATURDAY");
    assertEquals(2, bujo2.allEvents.size());
    bujo2.addEvent(event7, "sunday");
    assertEquals(3, bujo2.allEvents.size());

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      bujo1.addEvent(event1, "invalidDay");
    });
  }

  @Test
  void testCreateDays() {
    bujo1.days.clear();
    bujo2.days.clear();
    assertEquals(0, bujo1.days.size());
    assertEquals(0, bujo2.days.size());

    bujo1.createDays();
    assertEquals(7, bujo1.days.size());

    bujo2.createDays();
    assertEquals(7, bujo2.days.size());
  }

  @Test
  void testGetTasks() {
    List<Task> taskList1 = new ArrayList<>();
    taskList1.add(task1);
    taskList1.add(task2);
    taskList1.add(task3);
    taskList1.add(task4);

    bujo1.allTasks = taskList1;
    assertEquals(taskList1, bujo1.getTasks());

    List<Task> taskList2 = new ArrayList<>();
    taskList2.add(task1);
    taskList2.add(task2);
    taskList2.add(task3);
    taskList2.add(task4);

    bujo2.allTasks = taskList2;
    assertEquals(taskList2, bujo2.getTasks());
  }

  @Test
  void testGetEvents() {
    assertEquals(0, bujo1.allEvents.size());
    assertEquals(0, bujo2.allEvents.size());

    bujo1.allEvents.add(event1);
    bujo2.allEvents.add(event2);

    assertEquals(1, bujo1.getEvents().size());
    assertEquals(1, bujo2.getEvents().size());
  }
}