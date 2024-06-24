package pointing.system.employee;

import java.time.LocalDate;

final class Driver extends Employee {
  public Driver(String firstname, String lastname, String identifier, LocalDate birthdate, LocalDate hireDate, LocalDate fireDate) {
    super(firstname, lastname, identifier, "driver", birthdate, hireDate, fireDate, 0, 0);
  }
}
