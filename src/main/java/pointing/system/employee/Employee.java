package pointing.system.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pointing.system.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public sealed class Employee permits SeniorManager, NormalEmployee, Guardian, Driver {
  protected final String firstname, lastname, identifier, categoryName;
  protected final LocalDate birthdate, hireDate, endContract;
  protected final int hoursAWeek;
  protected final double grossSalary;

  public double getWeekNetSalary(){
    return grossSalary * 0.8;
  }

  public WorkProperty workProperty(
    MonthWorkCalendar calendar,
    Set<AdditionalHour> additionalHours,
    Set<MajoredTime> majoredTimes
  ){
    return new WorkProperty(this, calendar, additionalHours, majoredTimes);
  }

  public double getSalaryByHoursInADay(int hour){
    return (hour * grossSalary) / hoursAWeek;
  }
}
