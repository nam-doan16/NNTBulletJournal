package cs3500.pa05.model.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for TaskEvent enumeration
 */
class TaskEventTest {
  /**
   * Test for TaskEvent values
   */
  @Test
  public void testValues() {
    TaskEvent[] values = TaskEvent.values();
    assertEquals(values.length, 2);
    assertEquals(values[0], TaskEvent.TASK);
    assertEquals(values[1], TaskEvent.EVENT);

    assertEquals(values[0].displayName, "Task");
    assertEquals(values[1].displayName, "Event");
  }

  /**
   * Test for TaskEvent valueOf
   */
  @Test
  public void testValueOf() {
    assertEquals(TaskEvent.valueOf("TASK"), TaskEvent.TASK);
    assertEquals(TaskEvent.valueOf("EVENT"), TaskEvent.EVENT);
  }
}