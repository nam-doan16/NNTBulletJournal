package cs3500.pa05.model;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to validate arguments
 */
public class ArgumentValidator {

  /**
   * empty constructor
   */
  private ArgumentValidator() {}

  /**
   * ensures the name given is not empty
   *
   * @param name the name given
   *
   * @return a non empty String as a name
   */
  public static String nonEmptyName(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("Invalid name.");
    } else {
      return name;
    }
  }

  /**
   * ensure the format of the time given is valid
   *
   * @param time a string representing the time
   *
   * @return a valid format string representing the time
   */
  public static String checkTimeFormat(String time) {
    if (time.isEmpty()) {
      throw new IllegalArgumentException("Cannot leave time empty!");
    } else if (time.contains(":") && time.length() == 5) {
      String[] hoursMinutes = time.split(":");
      for (String timeFormat : hoursMinutes) {
        checkStringNumber(timeFormat, "Incorrect time format! (e.g. 08:15)");
        if (timeFormat.length() != 2) {
          throw new IllegalArgumentException("Incorrect time format! (e.g. 08:15)");
        }
      }
    } else {
      throw new IllegalArgumentException("Incorrect time format! (e.g. 08:15)");
    }
    return time;
  }

  /**
   * checks to see if the given string can be converted into an integer
   *
   * @param strNum the number as a string
   * @param errorMessage the errorMessage to be thrown
   *
   * @return a valid integer converted from the number that was a string
   */
  public static int checkStringNumber(String strNum, String errorMessage) {
    int tempNum;
    try {
      tempNum = Integer.parseInt(strNum);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(errorMessage);
    }
    return tempNum;
  }

  /**
   * parses through a given string and returns only the link in the string
   *
   * @param description the string to be parsed through
   *
   * @return a valid Hyperlink
   */
  public static String linkParser(String description) {
    // Regular expression pattern to match URLs
    String pattern = "(https?://\\S+)";
    Pattern urlPattern = Pattern.compile(pattern);
    Matcher matcher = urlPattern.matcher(description);

    String link = null;

    // Replace URLs with clickable links
    StringBuilder result = new StringBuilder();
    int lastEnd = 0;
    while (matcher.find()) {
      String url = matcher.group();
      link = url;
    }

    return link;
  }
}
