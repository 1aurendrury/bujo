package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

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
    assertEquals("event (1:00 – 2:00)\ndesc\n", event.toString());
  }

}