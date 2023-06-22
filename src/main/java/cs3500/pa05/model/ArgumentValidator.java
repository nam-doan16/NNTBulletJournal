package cs3500.pa05.model;

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
        checkStringPosNumber(timeFormat, "Incorrect time format! (e.g. 08:15)");
        if (timeFormat.length() != 2) {
          throw new IllegalArgumentException("Incorrect time format! (e.g. 08:15)");
        }
      }
      int hour = Integer.parseInt(hoursMinutes[0]);
      int minutes = Integer.parseInt(hoursMinutes[1]);
      // negatives checked already
      if (hour > 12 || hour == 0 || minutes > 60) {
        throw new IllegalArgumentException("Incorrect time numbers");
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
  public static int checkStringPosNumber(String strNum, String errorMessage) {
    int tempNum;
    try {
      tempNum = Integer.parseInt(strNum);
      if (tempNum < 0) {
        throw new IllegalArgumentException("Negative numbers not allowed");
      }
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
  public static String giveValidLink(String description) {
    String link = "";

    if (!(description == null || description.isEmpty())) {

      // Regular expression pattern to match URLs
      String pattern = "(https?://\\S+)";
      Pattern urlPattern = Pattern.compile(pattern);
      Matcher matcher = urlPattern.matcher(description);
      // Replace URLs with clickable links
      while (matcher.find()) {
        link = matcher.group();
      }
    }

    return link;
  }
}
