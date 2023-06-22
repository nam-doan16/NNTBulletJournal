package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;

/**
 * represents an abstract TaskEvent
 */
public abstract class AbstTaskEvent {
  protected String name;
  protected String description;
  protected Days dayOfWeek;
  protected String link;

  /**
   * constructor
   *
   * @param name the name of the event/task
   * @param description the description of the task/event
   * @param dayOfWeek the day of the week the task/event is scheduled for
   * @param link the link given by the user in the description
   */
  public AbstTaskEvent(String name, String description, Days dayOfWeek, String link) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.link = link;
  }

  public abstract String[] getExtraDetails();

  /**
   * getter for this.link which was given by the user in the description
   *
   * @return a HyperLink
   */
  public String getLink() {
    return this.link;
  }

  /**
   * getter for this.name
   *
   * @return a String
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter for this.description
   *
   * @return a String
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * getter for this.dayOfWeek that the task takes place on
   *
   * @return Days
   */
  public Days getDayOfWeek() {
    return this.dayOfWeek;
  }
}
