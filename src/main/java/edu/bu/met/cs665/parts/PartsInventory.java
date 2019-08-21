package edu.bu.met.cs665.parts;

import edu.bu.met.cs665.Part;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartsInventory extends MaintenanceUtil {

  // Maps parts to its # years left until required maintenance
  private HashMap<Part, Integer> partsYears;
  // Current date
  private LocalDate date;

  public PartsInventory(LocalDate date) {
    partsYears = new HashMap<>();
    this.date = date;
  }

  // Returns part that has the closest required maintenance date out of parts list
  public Part getImmedateMaintenancePart() {
    if (partsYears.size() == 0) {
      return null;
    }
    List<Part> parts = new ArrayList<>();
    parts.addAll(partsYears.keySet());

    Part immediatePart = parts.get(0);
    for (Part part : parts) {
      if (partsYears.get(part) < partsYears.get(immediatePart)) {
        immediatePart = part;
      }
    }
    return immediatePart;
  }

  // Returns status of inventory by highest critical/warning state of its parts.
  // Otherwise, returns healthy.
  public String getStatus() {
    List<String> status = new ArrayList<>();
    for (Part part : partsYears.keySet()) {
      status.add(checkPartHealth(part, date));
    }
    if (status.contains("critical")) {
      return "critical";
    } else if (status.contains("warning")) {
      return "warning";
    } else {
      return "healthy";
    }
  }

  // Returns list of parts in critical condition, needing immediate maintenance
  public List<Part> getCriticalParts() {
    List<Part> criticalParts = new ArrayList<>();
    for (Part part : partsYears.keySet()) {
      if (checkPartHealth(part, date).equalsIgnoreCase("critical")) {
        criticalParts.add(part);
      }
    }
    return criticalParts;
  }

  // Returns list of parts with warnings, needing maintenance scheduling
  public List<Part> getWarningParts() {
    List<Part> warningParts = new ArrayList<>();
    for (Part part : partsYears.keySet()) {
      if (checkPartHealth(part, date).equalsIgnoreCase("warning")) {
        warningParts.add(part);
      }
    }
    return warningParts;
  }

  // Retunrs list of all parts in inventory
  public List<Part> getParts() {
    List<Part> parts = new ArrayList<>();
    parts.addAll(partsYears.keySet());
    return parts;
  }

  // Returns part's years left until required maintenance
  public int getYearsLeft(Part part) {
    return partsYears.get(part);
  }

  // Returns number of parts stored
  public int getSize() {
    return partsYears.size();
  }

  // Sets current date of inventory
  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  // Adds part as key and its # years left required for maintenance as value
  public void add(Part part) {
    partsYears.put(part, part.getYearsLeft(date));
  }

  // Removes part from inventory
  public void remove(Part part) {
    partsYears.remove(part);
  }

  // Checks if given part is member of inventory
  public boolean contains(Part part) {
    List<Part> parts = new ArrayList<>();
    parts.addAll(partsYears.keySet());
    return parts.contains(part);
  }

  // Returns current inventory of parts and its # years left until maintenance is required
  public void print() {
    System.out.println("\n--------------------------------------------");
    System.out.println("| Parts Inventory");
    partsYears.forEach((part, years) -> {
      System.out.println("|\t" + part.getName() + ": ");
      System.out.println("|\t\t" + years + " years left until required maintenance");
    });
    System.out.println("--------------------------------------------\n");
  }
}
