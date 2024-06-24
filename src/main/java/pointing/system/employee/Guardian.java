package pointing.system.employee;

import java.time.LocalDate;

public final class Guardian extends Employee {
  public Guardian(
    String firstname,
    String lastname,
    String identifier,
    LocalDate birthdate,
    LocalDate endContract,
    LocalDate fireDate
  ) {
    super(
      firstname,
      lastname,
      identifier,
      "guardian",
      birthdate,
      endContract,
      fireDate,
      56,
      100_000
    );
  }
}
