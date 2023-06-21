package cs3500.pa05.model;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentValidator {
  private ArgumentValidator() {}

  public static String nonEmptyName(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("Invalid name.");
    } else {
      return name;
    }
  }

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

  public static int checkStringNumber(String strNum, String errorMessage) {
    int tempNum;
    try {
      tempNum = Integer.parseInt(strNum);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(errorMessage);
    }
    return tempNum;
  }

  public static Hyperlink linkParser(String description) {
    // Regular expression pattern to match URLs
    String pattern = "(https?://\\S+)";
    Pattern urlPattern = Pattern.compile(pattern);
    Matcher matcher = urlPattern.matcher(description);

    Hyperlink link = null;

    // Replace URLs with clickable links
    StringBuilder result = new StringBuilder();
    int lastEnd = 0;
    while (matcher.find()) {
      String url = matcher.group();
      link = new Hyperlink(url);
    }

    return link;
  }
}
