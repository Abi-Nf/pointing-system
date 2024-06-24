package pointing.system;

import lombok.Getter;

import java.time.MonthDay;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class MonthWorkCalendar {
  private final int month;

  @Getter
  private final GregorianCalendar calendar = new GregorianCalendar();

  private final Set<MonthDay> dayOffs = new HashSet<>();

  public MonthWorkCalendar(int month){
    this.month = month;
    calendar.set(Calendar.MONTH, month);
  }

  public MonthWorkCalendar dayOff(int date){
    dayOffs.add(MonthDay.of(month + 1, date));
    return this;
  }

  public boolean isDayOff(int date){
    return dayOffs.contains(MonthDay.of(month + 1, date));
  }
}
