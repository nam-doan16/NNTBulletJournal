package cs3500.pa05.json;

import cs3500.pa05.controller.SaveController;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Day;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.enums.Days;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Converter {

  public TaskJson[] alltaskstoJson(List<Task> tasks) {
    TaskJson[] output = new TaskJson[tasks.size()];
    for(int i = 0; i < tasks.size(); i++) {
      TaskJson task = tasktoJson(tasks.get(i));
      output[i] = task;
    }
    return output;
  }

  public TaskJson tasktoJson(Task t) {
    String name = t.getName();
    String desc = t.getDescription();
    Days day = t.getDayOfWeek();
    TaskJson task = new TaskJson(name, desc, day, t.getLink());
    return task;
  }

  public EventJson eventtoJson(Event e) {
    String name = e.getName();
    String desc = e.getDescription();
    Days day = e.getDayOfWeek();
    int start = Integer.parseInt(e.getStartTimeString());
    int duration = e.getDuration();
    EventJson event = new EventJson(name, desc, start, duration, day, e.getLink());
    return event;
  }

  public WeekJson weektoJson(Week w) {
    int maxe = w.getMaxe();
    int maxt = w.getMaxt();
    String qandn = w.getQandn();
    String theme = w.getTheme();
    TaskJson[] tasks = alltaskstoJson(w.getTasks());
    String start = w.getStart();
    WeekJson week = new WeekJson(maxt, maxe, theme, qandn, tasks, start);

    return week;
  }

}
