package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EventTest {
  //test if invalid startTime is entered
  @Test
  void testInvalidEntry() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Event("TestEvent", "this is a test event", "Modnay", 0, 2.0);
    });

    assertEquals("Start time must be between 1 and 24, inclusive.", exception.getMessage());

    IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
      new Event("TestEvent", "this is a test event", "Modnay", 25, 2.0);
    });

    assertEquals("Start time must be between 1 and 24, inclusive.", exception.getMessage());
  }

  @Test
  void testValidEntry() {
    Event event = new Event("TestEvent", "this is a test event", "Monday", 1, 2.0);
    assertEquals(1, event.startTime);

    Event event2 = new Event("TestEvent", "this is a test event", "Monday", 10, 2.0);
    assertEquals(10, event2.startTime);

    Event event3 = new Event("TestEvent", "this is a test event", "Monday", 24, 2.0);
    assertEquals(24, event3.startTime);
  }

  @Test
  void testGetDay() {
    Event event = new Event("event", "desc", "Monday", 1, 1);
    assertEquals("Monday", event.getDay());
  }

  @Test
  void testToString() {
    Event event = new Event("event", "desc", "Monday", 1, 1);
    assertEquals("event (1:00 - 2:00)\ndesc\n", event.toString());
  }

  @Test
  void testGetUrl() {
    String string1 = "this is a message that https://google.com contains a link.";
    Event event1 = new Event("event", string1, "monday", 1, 1);
    assertEquals("https://google.com", event1.getUrl());

    String string2 = "this is a message without a url";
    Event event2 = new Event("event", string2, "monday", 1, 1);
    assertEquals("", event2.getUrl());

    String string3 = "this is a message that http://google.com contains a link.";
    Event event3 = new Event("event", string3, "monday", 1, 1);
    assertEquals("http://google.com", event3.getUrl());
  }

}