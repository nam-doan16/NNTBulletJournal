package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * represents the view for the calendar
 */
public interface CalendarView {
  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
  Scene load() throws IllegalStateException;
}
