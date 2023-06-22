package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTest {
  Day day1;
  Day day2;
  Task task1;
  Task task2;
  Task task3;
  Task task4;
  Event event1;
  Event event2;
  Event event3;
  Event event4;

  @BeforeEach
  void setup() {
    day1 = new Day();
    day2 = new Day();

    task1 = new Task("task1", "this is task 1", "monday", false);
    task2 = new Task("task2", "this is task 2", "tuesday", false);
    task3 = new Task("task3", "this is task 3", "wednesday", false);
    task4 = new Task("task4", "this is task 4", "thursday", false);
    event1 = new Event("event1", "this is event 1", "Monday", 12, 1);
    event2 = new Event("event2", "this is event 2", "Tuesday", 13, 2);
    event3 = new Event("event3", "this is event 3", "Wednesday", 15, 3);
    event4 = new Event("event4", "this is event 4", "Friday", 18, 4);
  }

  @Test
  void testAddEvent() {
    assertEquals(0, day1.events.size());
    day1.addEvent(event1, 10);
    assertEquals(1, day1.events.size());
    day1.addEvent(event2, 10);
    assertEquals(2, day1.events.size());

    //day1.addEvent(event1, 0);
    //assertEquals("Maximum number of events per day reached!", ControllerImpl.);

    assertEquals(0, day2.events.size());
    day2.addEvent(event3, 10);
    assertEquals(1, day2.events.size());
    day2.addEvent(event4, 10);
    assertEquals(2, day2.events.size());

  }

  @Test
  void testAddTasks() {
    assertEquals(0, day1.tasks.size());
    day1.addTasks(task1, 10);
    assertEquals(1, day1.tasks.size());
    day1.addTasks(task2, 10);
    assertEquals(2, day1.tasks.size());

    assertEquals(0, day2.tasks.size());
    day2.addTasks(task3, 10);
    assertEquals(1, day2.tasks.size());
    day2.addTasks(task4, 10);
    assertEquals(2, day2.tasks.size());
  }
}