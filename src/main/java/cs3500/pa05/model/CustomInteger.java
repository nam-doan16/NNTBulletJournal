package cs3500.pa05.model;

public class CustomInteger {
  private int integer;

  public CustomInteger(int integer) {
    this.integer = integer;
  }

  public void increment() {
    this.integer++;
  }

  public int getInteger() {
    return this.integer;
  }
}
