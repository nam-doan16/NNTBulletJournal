package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TimeNotation;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.model.theme.Minimalistic;
import cs3500.pa05.model.theme.ScrapBook;
import cs3500.pa05.model.theme.Space;
import cs3500.pa05.model.theme.Vintage;
import java.util.ArrayList;
import java.util.List;


public class Converter {

  public TaskJson[] alltaskstoJson(List<Task> tasks) {
    TaskJson[] output = new TaskJson[tasks.size()];
    for (int i = 0; i < tasks.size(); i++) {
      TaskJson task = tasktoJson(tasks.get(i));
      output[i] = task;
    }
    return output;
  }

  public TaskJson tasktoJson(Task t) {
    String name = t.getName();
    String desc = t.getDescription();
    Days day = t.getDayOfWeek();
    Boolean complete = t.getDone();
    TaskJson task = new TaskJson(name, desc, day, t.getLink(), complete);
    return task;
  }

  public EventJson eventtoJson(Event e) {
    String name = e.getName();
    String desc = e.getDescription();
    Days day = e.getDayOfWeek();
    String start = e.getStartTimeString();
    int duration = e.getDuration();
    EventJson event = new EventJson(name, desc, start, duration, day, e.getLink());
    return event;
  }

  public EventJson[] alleventstoJson(List<Event> events) {
    EventJson[] output = new EventJson[events.size()];
    for (int i = 0; i < events.size(); i++) {
      EventJson event = eventtoJson(events.get(i));
      output[i] = event;
    }
    return output;
  }

  public WeekJson weektoJson(Week w) {
    int maxe = w.getMaxe();
    int maxt = w.getMaxt();
    String qandn = w.getQandn();
    String theme = w.getTheme();
    TaskJson[] tasks = alltaskstoJson(w.getTasks());
    EventJson[] events = alleventstoJson(w.getEvents());
    String start = w.getStart();
    WeekJson week = new WeekJson(maxt, maxe, theme, qandn, tasks, events, start);
    return week;
  }

  public Week jsonToWeek(WeekJson json) {
    Week week = new Week();
    WeekJson wjson = new ObjectMapper().convertValue(json, WeekJson.class);
    week.setMaxe(wjson.maxe());
    week.setMaxt(wjson.maxt());
    week.setqandn(wjson.notes());
    String theme = wjson.theme();
    if (theme.equals("minimal")) {
      week.setThem(new Minimalistic());
    }
    if (theme.equals("scrapbook")) {
      week.setThem(new ScrapBook());
    }
    if (theme.equals("vintage")) {
      week.setThem(new Vintage());
    }
    if (theme.equals("space")) {
      week.setThem(new Space());
    }
    List<Task> tasks = alljsontotasks(wjson.tasks());
    for (Task t : tasks) {
      week.addtask(t);
    }
    List<Event> events = alljsontoevents(wjson.events());
    for (Event e : events) {
      week.addEvent(e);
    }
    week.setStart(wjson.start());
    return week;
  }

  public List<Task> alljsontotasks(TaskJson[] tasks) {
    List<Task> out = new ArrayList<>();
    for (TaskJson t : tasks) {
      Task task = new Task(t.name(), t.details(), t.day(), t.link());
      out.add(task);
    }
    return out;
  }

  public List<Event> alljsontoevents(EventJson[] events) {
    List<Event> out = new ArrayList<>();
    for (EventJson t : events) {
      Event event = new Event(t.name(), t.details(), t.day(), t.start(), TimeNotation.PM,
          t.time(), t.link());
      out.add(event);
    }
    return out;
  }
}
