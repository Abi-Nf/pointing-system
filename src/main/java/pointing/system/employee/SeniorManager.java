package pointing.system.employee;

import java.time.LocalDate;

final class SeniorManager extends Employee {
  public SeniorManager(
    String firstname,
    String lastname,
    String identifier,
    LocalDate birthdate,
    LocalDate hireDate,
    LocalDate fireDate
  ) {
    super(
      firstname,
      lastname,
      identifier,
      "employee",
      birthdate,
      hireDate,
      fireDate,
      0,
      0
    );
  }
}
