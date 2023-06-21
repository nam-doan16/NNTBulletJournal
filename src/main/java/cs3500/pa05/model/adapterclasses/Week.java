package cs3500.pa05.model.adapterclasses;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.theme.AbstTheme;
import java.util.ArrayList;
import java.util.List;

public class Week {
  int maxt;
  int maxe;
  String qandn;
  List<Task> alltasks = new ArrayList<>();
  List<Event> events = new ArrayList<>();
  String theme;

  public void setMaxt(int m) {
    this.maxt = m;
  }

  public void setMaxe(int m) {
    this.maxe = m;
  }

  public void setQandn(String content) {
    this.qandn = content;
  }

  public void addtask(Task task) {
    this.alltasks.add(task);
  }

  public void addEvent(Event e) {
    this.events.add(e);
  }

  public void removeEvent(Event e) {
    this.events.remove(e);
  }

  public void removeTask(Task t) {
    this.alltasks.remove(t);
  }

  public void setThem (AbstTheme theme) {
    this.theme = theme.getName();
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
}