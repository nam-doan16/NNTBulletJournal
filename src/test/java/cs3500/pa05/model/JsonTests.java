package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.WeekJson;
import org.junit.jupiter.api.Test;

public class JsonTests {
  @Test
  public void testJson() {
    EventJson event = new EventJson("beach", "fun", "11:11",
        60, Days.SATURDAY, "");
    TaskJson task = new TaskJson("laundry", "chore", Days.SATURDAY, "",
        false);
    WeekJson week = new WeekJson(3, 3, "minimal", "lol", new TaskJson[]{task},
        new EventJson[]{event}, "Monday");

    assertNotNull(week);
    assertEquals(task.name(), "laundry");
    assertEquals(task.details(), "chore");
    assertEquals(task.day(), Days.SATURDAY);
    assertEquals(task.link(), "");
    assertEquals(task.done(), false);
    assertEquals(event.name(), "beach");
    assertEquals(event.details(), "fun");
    assertEquals(event.start(), "11:11");
    assertEquals(event.time(), 60);
    assertEquals(event.day(), Days.SATURDAY);
    assertEquals(event.link(), "");
    assertEquals(week.maxt(), 3);
    assertEquals(week.maxe(), 3);
    assertEquals(week.theme(), "minimal");
    assertEquals(week.notes(), "lol");
    assertEquals(week.tasks().length, 1);
    assertEquals(week.events().length, 1);
    assertEquals(week.start(), "Monday");
  }
}
