package cs3500.pa05.model.enums;

/**
 * enumeration representing either a task or an event
 */
public enum TaskEvent {

  /**
   * represents a Task
   */
  TASK("Task"),

  /**
   * represents an Event
   */
  EVENT("Event");

  public final String displayName;

  /**
   * sets the display name of each enum
   *
   * @param displayName the string that will be displayed as the name of the enum
   */
  private TaskEvent(String displayName) {
    this.displayName = displayName;
  }

}
