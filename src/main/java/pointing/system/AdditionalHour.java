package pointing.system;

import pointing.system.employee.Employee;

import java.util.Objects;

public class AdditionalHour {
  private final int hourRate;
  private final double additionalSalaryPercent;

  public AdditionalHour(int hourRate, double additionalSalaryPercent){
    this.hourRate = hourRate;
    this.additionalSalaryPercent = additionalSalaryPercent;
  }

  public double getSalary(Employee employee, int hourOfWork){
    if(hourOfWork > 20) return 0;
    if(hourOfWork == hourRate){
      return employee.getSalaryByHoursInADay(hourOfWork) * additionalSalaryPercent;
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AdditionalHour that)) return false;
    return hourRate == that.hourRate && Double.compare(additionalSalaryPercent, that.additionalSalaryPercent) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hourRate, additionalSalaryPercent);
  }
}
