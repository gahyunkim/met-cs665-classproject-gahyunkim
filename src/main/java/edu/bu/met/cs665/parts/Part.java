package edu.bu.met.cs665.parts;

import java.time.LocalDate;

public interface Part {

  void setLifespan(int years);

  int getLifespan();

   void setStartDate(LocalDate date);

   LocalDate getStartDate();

   void setBuffer(int buffer);

   int getBuffer();

   void setName(String name);

   String getName();

   String checkHealth(LocalDate date);

   int getYearsLeft(LocalDate date);
}
