package edu.bu.met.cs665.parts;

import java.time.LocalDate;

public class MaintenanceUtil {

  public String checkPartHealth(Part part, LocalDate date) {
    int remainingYears = getPartYearsLeft(part, date);
    if (remainingYears <= 0) {
      return "critical";
    } else if (remainingYears <= part.getBuffer()) {
      return "warning";
    } else {
      return "healthy";
    }
  }

  public int getPartYearsLeft(Part part, LocalDate date) {
    int ageYears = date.getYear() - part.getStartDate().getYear();
    int remainingYears = part.getLifespan() - ageYears;
    return remainingYears;
  }

  public void performPartMaintenance(Part part, LocalDate date) {
    System.out.println("Tuning up " + part.getName());
    part.setStartDate(date);
  }
}
