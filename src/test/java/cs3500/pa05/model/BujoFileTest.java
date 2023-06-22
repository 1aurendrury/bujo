package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BujoFileTest {
  BujoFile bujoFile1;
  BujoFile bujoFile2;
  List<Day> days;
  Day monday;
  Day tues;
  Day wed;
  Day thurs;
  Day fri;
  Day sat;
  Day sun;

  @BeforeEach
  void setup() {
    this.monday = new Day();
    this.tues = new Day();
    this.wed = new Day();
    this.thurs = new Day();
    this.fri = new Day();
    this.sat = new Day();
    this.sun = new Day();

    this.days = new ArrayList<>();

    this.days.add(sun);
    this.days.add(monday);
    this.days.add(tues);
    this.days.add(wed);
    this.days.add(thurs);
    this.days.add(fri);
    this.days.add(sat);

    bujoFile1 = new BujoFile("lightmode.fxml", "light mode", days);
    bujoFile2 = new BujoFile("darktheme.fxml", "dark mode", days);
  }

  @Test
  void testSetMaxTasks() {
    assertEquals(bujoFile1.maxTasks, 0);
    assertEquals(bujoFile2.maxTasks, 0);

    bujoFile1.setMaxTasks(5);
    assertEquals(bujoFile1.maxTasks, 5);
    bujoFile1.setMaxTasks(3);
    assertEquals(bujoFile1.maxTasks, 3);

    bujoFile2.setMaxTasks(10);
    assertEquals(bujoFile2.maxTasks, 10);
    bujoFile2.setMaxTasks(4);
    assertEquals(bujoFile2.maxTasks, 4);
  }

  @Test
  void testSetMaxEvents() {
    assertEquals(bujoFile1.maxEvents, 0);
    assertEquals(bujoFile2.maxEvents, 0);

    bujoFile1.setMaxEvents(5);
    assertEquals(bujoFile1.maxEvents, 5);
    bujoFile1.setMaxEvents(3);
    assertEquals(bujoFile1.maxEvents, 3);

    bujoFile2.setMaxEvents(10);
    assertEquals(bujoFile2.maxEvents, 10);
    bujoFile2.setMaxEvents(4);
    assertEquals(bujoFile2.maxEvents, 4);
  }

  @Test
  void testSetTheme() {
    assertEquals(bujoFile1.theme, "lightmode.fxml");
    bujoFile1.setTheme("darktheme.fxml");
    assertEquals(bujoFile1.theme, "darktheme.fxml");

    assertEquals(bujoFile2.theme, "darktheme.fxml");
    bujoFile2.setTheme("lightmode.fxml");
    assertEquals(bujoFile2.theme, "lightmode.fxml");
  }
}