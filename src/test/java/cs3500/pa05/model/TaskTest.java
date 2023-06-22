package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
  Task task1;
  Task task2;
  Task task3;
  Task task4;
  Task task5;
  String string1;
  String string2;
  String string3;

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

  @Test
  void testGetUrl() {
    string1 = "this is a message that https://google.com contains a link.";
    task3 = new Task("task", string1, "monday", false);
    assertEquals("https://google.com", task3.getUrl());

    string2 = "this is a message without a url";
    task4 = new Task("task", string2, "monday", false);
    assertEquals("", task4.getUrl());

    string3 = "this is a message that http://google.com contains a link.";
    task5 = new Task("task", string3, "monday", false);
    assertEquals("http://google.com", task5.getUrl());
  }

}