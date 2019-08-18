package edu.bu.met.cs665.parts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartsInventory {

  private HashMap<Part, Integer> partsYears;
  private LocalDate date;

  public PartsInventory(LocalDate date) {
    partsYears = new HashMap<>();
    this.date = date;
  }

  public Part getCriticalMaintenancePart() {
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

  public int getYearsLeft(Part part) {
    return partsYears.get(part);
  }

  public int getSize() {
    return partsYears.size();
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  public void add(Part part) {
    partsYears.put(part, part.getYearsLeft(date));
  }

  public void remove(Part part) {
    partsYears.remove(part);
  }

  public boolean contains(Part part) {
    List<Part> parts = new ArrayList<>();
    parts.addAll(partsYears.keySet());
    return parts.contains(part);
  }
}
