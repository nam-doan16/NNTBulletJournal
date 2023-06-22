package cs3500.pa05.model.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TimeNotation;
import cs3500.pa05.model.theme.AbstTheme;
import cs3500.pa05.model.theme.Minimalistic;
import cs3500.pa05.model.theme.Space;
import org.junit.jupiter.api.Test;

public class WeekTest {
  private Week week = new Week();

  @Test
  public void testSetMaxt() {
    week.setMaxt(10);
    assertEquals(week.getMaxt(), 10);
  }

  @Test
  public void testSetMaxe() {
    week.setMaxe(10);
    assertEquals(week.getMaxe(), 10);
  }

  @Test
  public void testAddTask() {
    Task t = new Task("beach", "fun", Days.MONDAY, "");
    week.addtask(t);
    assertEquals(week.getTasks().size(), 1);
  }

  @Test
  public void testAddEvent() {
    Event e = new Event("party", "fun", Days.FRIDAY, "11:11",
        TimeNotation.PM, 180, "");
    week.addEvent(e);
    assertEquals(week.getEvents().size(), 1);
  }

  @Test
  public void testSetTheme() {
    AbstTheme theme = new Minimalistic();
    week.setThem(theme);
    assertEquals(week.getTheme(), "minimal");
  }


  @Test
  public void testSetQandN() {
    week.setqandn("lol");
    assertEquals(week.getQandn(), "lol");
  }

  @Test
  public void testGetMaxt() {
    assertEquals(week.getMaxt(), 0);
    week.setMaxt(10);
    assertEquals(week.getMaxt(), 10);
  }

  @Test
  public void testGetMaxe() {
    assertEquals(week.getMaxe(), 0);
    week.setMaxt(3);
    assertEquals(week.getMaxt(), 3);
  }

  @Test
  public void getQandN() {
    assertEquals(week.getQandn(), "");
    week.setqandn("lol");
    assertEquals(week.getQandn(), "lol");

  }

  @Test
  public void testgetTasks() {
    assertEquals(week.getTasks().size(), 0);
    Task t = new Task("beach", "fun", Days.MONDAY, "");
    week.addtask(t);
    assertEquals(week.getTasks().size(), 1);
  }

  @Test
  public void testGetEvents() {
    assertEquals(week.getEvents().size(), 0);
    Event e = new Event("party", "fun", Days.FRIDAY, "11:11",
        TimeNotation.PM, 180, "");
    week.addEvent(e);
    assertEquals(week.getEvents().size(), 1);
  }

  @Test
  public void testGetTheme() {
    assertEquals(week.getTheme(), "Default");
    week.setThem(new Space());
    assertEquals(week.getTheme(), "space");
  }

  @Test
  public void testGetStart() {
    assertEquals(week.getStart(), "Sunday");
  }

  @Test
  public void setStart() {
    week.setStart("Monday");
    assertEquals(week.getStart(), "Monday");
  }

  @Test
  public void testGetInt() {
    assertEquals(week.getint(), 0);
    week.setStart("Tuesday");
    assertEquals(week.getint(), 2);
    week.setStart("Wednesday");
    assertEquals(week.getint(), 3);
    week.setStart("Thursday");
    assertEquals(week.getint(), 4);
    week.setStart("Friday");
    assertEquals(week.getint(), 5);
    week.setStart("Saturday");
    assertEquals(week.getint(), 6);
    week.setStart("Monday");
    assertEquals(week.getint(), 1);
  }
}
