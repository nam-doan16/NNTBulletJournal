package cs3500.pa05.model.adapterclasses;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.theme.AbstTheme;
import java.util.ArrayList;
import java.util.List;

public class Week {
  int maxt = 0;
  int maxe = 0;
  String qandn = "";
  List<Task> alltasks = new ArrayList<>();
  List<Event> events = new ArrayList<>();
  String theme = "Default";
  String start = "Sunday";

  public void setMaxt(int m) {
    this.maxt = m;
  }

  public void setMaxe(int m) {
    this.maxe = m;
  }

  public void addtask(Task task) {
    this.alltasks.add(task);
  }

  public void addEvent(Event e) {
    this.events.add(e);
  }

  public void setThem(AbstTheme theme) {
    this.theme = theme.getName();
  }

  public void setqandn(String qandn) {
    this.qandn = qandn;
  }

  public int getMaxt() {
    return this.maxt;
  }

  public int getMaxe() {
    return this.maxe;
  }

  public String getQandn() {
    return this.qandn;
  }

  public List<Task> getTasks() {
    return this.alltasks;
  }

  public List<Event> getEvents() {
    return this.events;
  }

  public String getTheme() {
    return this.theme;
  }

  public String getStart() {
    return this.start;
  }

  public void setStart(String day) {
    this.start = day;
  }

  public int getint() {
    if (start.equals("Sunday")) {
      return 0;
    }
    if (start.equals("Monday")) {
      return 1;
    }
    if (start.equals("Tuesday")) {
      return 2;
    }
    if (start.equals("Wednesday")) {
      return 3;
    }
    if (start.equals("Thursday")) {
      return 4;
    }
    if (start.equals("Friday")) {
      return 5;
    } else {
      return 6;
    }
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  public void setTasks(List<Task> tasks) {
    this.alltasks = tasks;
  }
}
