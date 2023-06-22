package cs3500.pa05.model.enums;

/**
 * enumeration representing the days of the week
 */
public enum Days {

  /**
   * represents sunday
   */
  SUNDAY(0),

  /**
   * represents monday
   */
  MONDAY(1),

  /**
   * represents tuesday
   */
  TUESDAY(2),

  /**
   * represents wednesday
   */
  WEDNESDAY(3),

  /**
   * represents thursday
   */
  THURSDAY(4),

  /**
   * represents friday
   */
  FRIDAY(5),

  /**
   * represents saturday
   */
  SATURDAY(6);

  /**
   * the numerical representation of each day of the week
   */
  public final int numRepresentation;

  /**
   * sets the numerical representation of each day of the week
   * Sunday is 0
   * Monday is 1
   * Tuesday is 2
   * Wednesday is 3
   * Thursday is 4
   * Friday is 5
   * Saturday is 6
   *
   * @param numRepresentation an int representing each day of the week
   */
  Days(int numRepresentation) {
    this.numRepresentation = numRepresentation;
  }
}
