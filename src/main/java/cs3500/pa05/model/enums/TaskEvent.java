package cs3500.pa05.model.enums;

public enum TaskEvent {
  TASK("Task"), EVENT("Event");

  public final String displayName;

  private TaskEvent(String displayName) {
    this.displayName = displayName;
  }

}
