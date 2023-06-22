package cs3500.pa05.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TimeNotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for AbstTaskEvent and its subclasses Task and Event
 */
class AbstTaskEventTest {
  private AbstTaskEvent event;
  private AbstTaskEvent task;
  private Event event2;

  @BeforeEach
  public void setUp() {
    this.event = new Event("event", "hi", Days.WEDNESDAY, "09:15",
        TimeNotation.AM, 60, "https://google.com");
    this.task = new Task("task", "world", Days.MONDAY, "https://apple.com");
    this.event2 = new Event("event", "hi", Days.WEDNESDAY, "09:15",
        TimeNotation.AM, 59, "https://google.com");
  }

  @Test
  void getExtraDetails() {
    String[] eventDetails = this.event.getExtraDetails();
    assertEquals(eventDetails[0], "Start time: 09:15AM");
    assertEquals(eventDetails[1], "Duration: 1 hours, 0 minutes");

    String[] eventDetails2 = this.event2.getExtraDetails();
    assertEquals(eventDetails2[0], "Start time: 09:15AM");
    assertEquals(eventDetails2[1], "Duration: 59 minutes");

    String[] taskDetails = this.task.getExtraDetails();
    assertEquals(taskDetails[0], "COMPLETE? NO");
  }

  @Test
  public void testGetDuration() {
    assertEquals(event2.getDuration(), 59);
  }

  @Test
  public void testGetStartTimeString() {
    assertEquals(event2.getStartTimeString(), "09:15");
  }

  @Test
  void getLink() {
    assertEquals(this.task.getLink(), "https://apple.com");
    assertEquals(this.event.getLink(), "https://google.com");
  }

  @Test
  void getName() {
    assertEquals(this.task.getName(), "task");
    assertEquals(this.event.getName(), "event");
  }

  @Test
  void getDescription() {
    assertEquals(this.task.getDescription(), "world");
    assertEquals(this.event.getDescription(), "hi");
  }

  @Test
  void getDayOfWeek() {
    assertEquals(this.task.getDayOfWeek(), Days.MONDAY);
    assertEquals(this.event.getDayOfWeek(), Days.WEDNESDAY);
  }

  @Test
  void getDone() {
    Task task = (Task) this.task;
    assertFalse(task.getDone());
  }
}