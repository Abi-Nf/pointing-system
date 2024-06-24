package pointing.system;

import pointing.system.employee.Employee;

import java.util.Objects;

public class MajoredTime {
  private final double percent;
  private final TriFunction<Integer, WorkDay, MonthWorkCalendar, Boolean> when;

  MajoredTime(
    double percent,
    TriFunction<Integer, WorkDay, MonthWorkCalendar, Boolean> when
  ){
    this.percent = percent;
    this.when = when;
  }

  public double getSalary(Employee employee, int hours, int date, WorkDay workDay, MonthWorkCalendar calendar){
    if (when.apply(date, workDay, calendar)) {
      return employee.getSalaryByHoursInADay(hours) * percent;
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MajoredTime that)) return false;
    return Double.compare(percent, that.percent) == 0 && Objects.equals(when, that.when);
  }

  @Override
  public int hashCode() {
    return Objects.hash(percent, when);
  }
}
