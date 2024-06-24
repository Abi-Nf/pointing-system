package pointing.system;

import pointing.system.employee.Employee;

import java.util.Set;

public class WorkProperty {
  private final Employee employee;
  private final MonthWorkCalendar monthCalendar;
  private final Set<AdditionalHour> additionalHours;
  private final Set<MajoredTime> majoredTimes;

  private int hourOfWork = 0;
  private double salary = 0;
  private int daysOfWork = 0;

  public WorkProperty(
    Employee employee,
    MonthWorkCalendar monthCalendar,
    Set<AdditionalHour> additionalHours,
    Set<MajoredTime> majoredTimes
  ){
    this.employee = employee;
    this.monthCalendar = monthCalendar;
    this.additionalHours = additionalHours;
    this.majoredTimes = majoredTimes;
  }

  public WorkProperty work(WorkDay workDay, int hourOfWork, int date){
    if(hourOfWork > 24){
      throw new IllegalArgumentException("A day is only between 0 and 24 hours");
    }
    this.hourOfWork+=hourOfWork;
    this.daysOfWork++;
    checkForSalary(workDay, hourOfWork, date);
    return this;
  }

  public WorkProperty work(WorkDay workDay, int hourOfWorkADay, int startDate, int endDate){
    var days = (endDate - startDate) + 1;
    this.hourOfWork = days * hourOfWorkADay;
    this.daysOfWork += days;
    for (int i = startDate; i <= endDate; i++){
      checkForSalary(workDay, hourOfWorkADay, i);
    }
    return this;
  }

  private void checkForSalary(WorkDay workDay, int hourOfWork, int date){
    double additionalHoursSalary = additionalHours
      .stream()
      .mapToDouble(v -> v.getSalary(employee, hourOfWork))
      .sum();
    double majoredTimeSalary = majoredTimes
      .stream()
      .mapToDouble(v -> v.getSalary(employee, hourOfWork, date, workDay, monthCalendar))
      .sum();
    this.salary += employee.getSalaryByHoursInADay(hourOfWork) + additionalHoursSalary + majoredTimeSalary;
  }

  public int getTotalWorkHours(){
    return hourOfWork;
  }

  public int getTotalDaysOfWork() {
    return daysOfWork;
  }

  public double getTotalGrossSalary(){
    return salary;
  }
}
