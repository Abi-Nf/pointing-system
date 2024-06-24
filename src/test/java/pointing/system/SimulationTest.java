package pointing.system;

import org.junit.jupiter.api.Test;
import pointing.system.employee.Guardian;

import java.util.Calendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {
  @Test
  public void test_de_salaire(){
    var guardianCalendarOfJune = new MonthWorkCalendar(Calendar.JUNE)
      .dayOff(17).dayOff(25).dayOff(26);

    var additional8hours = new AdditionalHour(8, 1.3);
    var additional12Hors = new AdditionalHour(12, 1.5);

    var majoredAtNight = new MajoredTime(1.3, (_, workDay, _) -> workDay == WorkDay.NIGHT);
    var majoredAtSunday = new MajoredTime(
      1.4,
      (_, _, calendar) -> calendar.getCalendar().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
    );
    var majoredAtHolidays = new MajoredTime(1.5, (date, _, calendar) -> calendar.isDayOff(date));

    var rakoto = new Guardian(
      "Rakoto",
      "Be",
      "",
      null,
      null,
      null
    );

    var rakotoWorks = rakoto.workProperty(
        guardianCalendarOfJune,
        Set.of(additional8hours, additional12Hors),
        Set.of(majoredAtNight, majoredAtSunday, majoredAtHolidays)
      )
      .work(WorkDay.DAY, 8, 1, 25)
      .work(WorkDay.DAY, 8, 27, 30);

    assertEquals(29, rakotoWorks.getTotalDaysOfWork());
  }
}
