package ValidateInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import FlightInformation.FlightInformation;
import ExtraFlightInformation.ExtraFlightInformation;



public class ValidateInformation {

  private static final int maxAttempts = 3;
  private FlightInformation startFlights;
  private ExtraFlightInformation endFlights;

  public ValidateInformation(FlightInformation startFlights, ExtraFlightInformation endFlights) {
    this.startFlights = startFlights;
    this.endFlights = endFlights;
  }

  private static void displayAttemptsRemaining(int attempts, int maxAttempts) {
      System.out.println("You have " + (maxAttempts - attempts) + " attempts left!"); 
  }

  public void validateFlightInformation() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startFlightDate = LocalDate.parse(startFlights.getFlightDate(), formatter);
        LocalDate endFlightDate = LocalDate.parse(endFlights.getReturnFlightDate(), formatter);

        if (startFlightDate.equals(endFlightDate) || startFlightDate.isAfter(endFlightDate)) {
          attempts++;
          if (attempts == maxAttempts) {
            System.out.println("Maximum attempts reached. Booking process must be restarted.");
            return;
          }

          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Invalid flight dates. Please re-enter return flight details:");
          endFlights.returnFlightDate();
          endFlights.returnFlightTime();
          endFlights.returnFlightSeatNumber();
      } 
    }
  }

public void displayHolidayDuration(LocalDate startDate, LocalDate endDate) {
    long days = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    System.out.println("Your holiday duration is " + days + " days.");
  }
}
