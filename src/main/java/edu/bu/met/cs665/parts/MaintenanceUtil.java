package edu.bu.met.cs665.parts;

import edu.bu.met.cs665.Part;
import java.time.LocalDate;

public class MaintenanceUtil {

  // Assesses part's health status based on its buffer (# years till maintenance where
  // warning is triggered) and current date.
  // Returns healthy/warning/critical status
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

  // Computes and returns number of years left a part has until required maintenance based
  // on its lifespan and current date
  public int getPartYearsLeft(Part part, LocalDate date) {
    int ageYears = date.getYear() - part.getStartDate().getYear();
    int remainingYears = part.getLifespan() - ageYears;
    return remainingYears;
  }

  // Performs maintenance on given part and resets start date to current date
  public void performPartMaintenance(Part part, LocalDate date) {
    System.out.println("- Tuning up " + part.getName() + " . . .");
    part.setStartDate(date);
  }

  public void printMaintenance(Part part, LocalDate date) {
    System.out.println("Part " + part.getName() + " inspection");
    System.out.print(" due in " + part.getYearsLeft(date));
  }
}
