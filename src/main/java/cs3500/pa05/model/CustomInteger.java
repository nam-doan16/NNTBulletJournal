package cs3500.pa05.model;

/**
 * Represents a CustomInteger
 */
public class CustomInteger {
  private int integer;

  /**
   * Constructor for CustomInteger
   *
   * @param integer integer
   */
  public CustomInteger(int integer) {
    this.integer = integer;
  }

  /**
   * Increments this integer by 1
   */
  public void increment() {
    this.integer++;
  }

  /**
   * getter method for integer
   *
   * @return integer
   */
  public int getInteger() {
    return this.integer;
  }
}
