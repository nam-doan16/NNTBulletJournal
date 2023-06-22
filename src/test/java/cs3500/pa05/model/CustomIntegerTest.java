package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for CustomInteger
 */
public class CustomIntegerTest {
  /**
   * test for increment
   */
  @Test
  void testIncrement() {
    CustomInteger s = new CustomInteger(2);
    assertEquals(s.getInteger(), 2);

    // incrementing
    s.increment();

    assertEquals(s.getInteger(), 3);
  }

  /**
   * test for getInteger
   */
  @Test
  void testGetInteger() {
    CustomInteger test = new CustomInteger(100);
    assertEquals(test.getInteger(), 100);
  }
}