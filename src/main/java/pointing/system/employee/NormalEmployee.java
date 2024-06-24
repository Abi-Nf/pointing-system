package pointing.system.employee;

import java.time.LocalDate;

public final class NormalEmployee extends Employee {
  public NormalEmployee(
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
      "normal",
      birthdate,
      hireDate,
      fireDate,
      40,
      100_000
    );
  }
}
