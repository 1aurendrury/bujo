package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
  Task task1;
  Task task2;

  @BeforeEach
  void setup() {
    task1 = new Task("task1", "desc", "Monday", false);
    task2 = new Task("task2", "desc", "Tuesday", true);
  }

  @Test
  void testGetDay() {
    assertEquals("Monday", task1.getDay());
    assertEquals("Tuesday", task2.getDay());
  }

  @Test
  void testToString() {
    assertEquals("task1\ndesc\nNot complete", task1.toString());
    assertEquals("task2\ndesc\nComplete", task2.toString());
  }

}