package FlightInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FlightInformation extends UserInformation implements UserInterface {

  private static final int maxAttempts = 3;

  private static final String[] destinations = {"Cairo", "Seoul", "New York", "Tokyo", "Dubai", "Singapore", "Sydney", "Hong Kong","Toronto", "Barcelona", "Rome", "Amsterdam", "Berlin", "Istanbul", "Bangkok"};

  private static final String[] times = {
    "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30",
    "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30",
    "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
    "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
    "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
    "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"
  };

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final LocalDate startDate = LocalDate.parse("20/03/2025", formatter);
  private static final LocalDate endDate = LocalDate.parse("01/12/2026", formatter);
  private static final ArrayList<LocalDate> dates = new ArrayList<LocalDate>();

  static {
   LocalDate current = startDate;
   while (!current.isAfter(endDate)) {
      dates.add(current);
      current = current.plusDays(1);
   }
  } 

 private static final ArrayList<String> seatNumbers = new ArrayList<String>();

 static {
  for (int i = 1; i <= 500; i++) {
    seatNumbers.add(String.valueOf(i));
  }
 }

  private ArrayList<String>flightDestination = new ArrayList<String>();
  private ArrayList<String>flightDate = new ArrayList<String>();
  private ArrayList<String>flightTime = new ArrayList<String>();
  private ArrayList<String>flightSeatNumber = new ArrayList<String>();

  public FlightInformation(String firstName, String lastName, int age, String gender, String emailAddress, String phoneNumber, String flightDestination, String flightDate, String flightTime, String flightSeatNumber) {

    super(firstName, lastName, age, gender, emailAddress, phoneNumber, 0);
    this.flightDestination.add(flightDestination);
    this.flightDate.add(flightDate);
    this.flightTime.add(flightTime);
    this.flightSeatNumber.add(flightSeatNumber);

  }

  public String getFlightDestination() {
    return flightDestination.get(currentIndex);
  }

  public String getFlightDate() {
    return flightDate.get(currentIndex);
  }

  public String getFlightTime() {
    return flightTime.get(currentIndex);
  }

  public String getFlightSeatNumber() {
    return flightSeatNumber.get(currentIndex);
  }

  public void setFlightDestination(String flightDestination) {

    if (flightDestination == null || flightDestination.trim().isEmpty()) {
      throw new IllegalFlightDestinationException("Flight destination is empty!");
    }

    for (int i = 0; i < destinations.length; i++) {
      if (flightDestination.equalsIgnoreCase(destinations[i])) {
        this.flightDestination.add(flightDestination);
        return;
        }
      }
    throw new IllegalFlightDestinationException("Flight destination either not available or invalid!");
  }

  public void setFlightTime(String flightTime) {

    if (flightTime == null || flightTime.trim().isEmpty()) {
      throw new IllegalFlightTimeException("Flight time is empty!");
    }

    for (int i = 0; i < times.length; i++) {
      if (flightTime.equalsIgnoreCase(times[i])) {
        this.flightTime.add(flightTime);
        return;
        }
      }
    throw new IllegalFlightTimeException("Flight time either not available or invalid!");
  }

  public void setFlightDate(String flightDate) {

    if (flightDate == null || flightDate.trim().isEmpty()) {
      throw new IllegalFlightDateException("Flight date is empty!");
    }

    try {
        LocalDate date = LocalDate.parse(flightDate, formatter);
        if (dates.contains(date)) {
          this.flightDate.add(flightDate);
          return;
        }
        throw new IllegalFlightDateException("Flight date not available or outside booking range!");
      } catch (Exception e) {
        throw new IllegalFlightDateException("Invalid date format! Use dd/MM/yyyy");
      }
    }

   public void setFlightSeatNumber(String flightSeatNumber) {

     if (flightSeatNumber == null || flightSeatNumber.trim().isEmpty()) {
       throw new IllegalFlightSeatNumberException("Flight seat number is empty!");
     }

     try {
       int seatNumber = Integer.parseInt(flightSeatNumber);
       if (seatNumber >= 1 && seatNumber <= 500) {
         this.flightSeatNumber.add(flightSeatNumber);
         return;
       }
       throw new IllegalFlightSeatNumberException("Flight seat number either invalid or out of range!");
     } catch (NumberFormatException e) {
       throw new IllegalFlightSeatNumberException("It must be a number");
     } 
   } 

  private static void displayAttemptsRemaining(int attempts, int maxAttempts) {
      System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");  
  }

   @Override
   public void flightDestination() {

     Scanner sc = new Scanner(System.in);
     int attempts = 0;

     while (attempts < maxAttempts) {

       try {

         for (int i = 0; i < destinations.length; i++) {
           System.out.println(destinations[i]);
         }

         System.out.println("Enter your flight destination shown in the listed array. You have 3 attempts to enter a valid flight destination: ");
         String inputflightDestination = sc.nextLine();
         attempts++;

         if (inputflightDestination == null || inputflightDestination.trim().isEmpty()) {
           if (attempts == maxAttempts) {
             System.out.println("You exceeded the number of attempts to enter a valid flight destination. Try again later: ");
             return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("No empty inputs allowed. Please try again: ");
           continue;
         }

         boolean found = false;
         for (int i = 0; i < destinations.length; i++) {
           if (inputflightDestination.equalsIgnoreCase(destinations[i])) {
             found = true;
             break;
           }
         }

         if (!found) {
           if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid flight destination. Try again later: ");
              return;
            }
            displayAttemptsRemaining(attempts, maxAttempts);
            System.out.println("Sorry, the flight destination is either invalid or not available in the array. Please try again: ");
           continue;
         }

         setFlightDestination(inputflightDestination);
         break;

       } catch (IllegalArgumentException e) {
         if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flight destination. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Error: " + e.getMessage());
       } finally {
         System.out.println("Flight destination entered successfully!");
       }
     }
   }

  @Override
  public void flightTime() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

        for (int i = 0; i < times.length; i++) {
          System.out.println(times[i]);
        }

        System.out.println("Enter your flight time shown in the listed array. You have 3 attempts to enter a valid flgiht time: ");
        String inputFlightTime = sc.nextLine();
        attempts++;

        if (inputFlightTime == null || inputFlightTime.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flight time. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("No empty inputs allowed. Please try again: ");
           continue;
         }

         boolean found = false;
         for (int i = 0; i < times.length; i++) {
           if (inputFlightTime.equalsIgnoreCase(times[i])) {
             found = true;
             break;
           }
         }

         if (!found) {
           if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid flight time. Try again later: ");
              return;
            }
            displayAttemptsRemaining(attempts, maxAttempts);
            System.out.println("Sorry, the flight time is either invalid or not available in the array. Please try again: ");
           continue;
         }

         setFlightTime(inputFlightTime);
         break;

       } catch (IllegalArgumentException e) {
         if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flight time. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Error: " + e.getMessage());
       } finally {
        System.out.println("Flight time entered successfully!");
      }
     }
   }

  @Override
  public void flightDate() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

        try {

          System.out.println("Enter your flight date in the format dd/mm/yyyy between 20/03/2025 and 01/12/2026. You have 3 attempts to enter a valid flight date: ");
          String inputFlightDate = sc.nextLine();
          attempts++;

          if (inputFlightDate == null || inputFlightDate.trim().isEmpty()) {
            if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid flight date. Try again later: ");
              return;
             }
             displayAttemptsRemaining(attempts, maxAttempts);
             System.out.println("No empty inputs allowed. Please try again: ");
             continue;
           }

          boolean found = false;
          String dateString = flightDate.get(currentIndex);
          LocalDate date = LocalDate.parse(dateString, formatter);
          if (dates.contains(date)) {
            found = true;
            break;
          }

          if (!found) {
            if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid flight date. Try again later: ");
              return;
             }
             displayAttemptsRemaining(attempts, maxAttempts);
             System.out.println("Sorry, the flight date is either invalid or unavailable in the array. Please try again: ");
            continue;
          }

          setFlightDate(inputFlightDate);
          break;

        } catch (IllegalArgumentException e) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flight date. Try again later: ");
            return;
           }
          System.out.println("Error: " + e.getMessage());
        } finally {
        System.out.println("Flight date entered successfully!");
      }
    }

  }

  @Override
  public void flightSeatNumber() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

        System.out.println("Enter a flight seat number from 1 to 500 as there are 500 seats in a plane. You have 3 attempts to enter a valid flight date: ");
        String inputFlightSeatNumber = sc.nextLine();
        attempts++;

        if (inputFlightSeatNumber == null || inputFlightSeatNumber.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flights seat number. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("No empty inputs allowed. Please try again: ");
           continue;
         }

        boolean found = false;
        int seatNumber = Integer.parseInt(inputFlightSeatNumber);
        if (seatNumbers.contains(String.valueOf(seatNumber))) {
          found = true;
          break;
        }

        if (!found) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid flights seat number. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("Sorry, the flight seat number is either invalid or unavailable in the array. Please try again: ");
          continue;
        }

        setFlightSeatNumber(inputFlightSeatNumber);
        break;

      } catch (IllegalArgumentException e) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid flight seat number. Try again later: ");
          return;
         }
        System.out.println("Error: " + e.getMessage());
      } finally {
        System.out.println("Flight seat number entered successfully!");
      }
    }
   }

  @Override
  public void confirm() {

    super.confirm();
    System.out.println("Flight destination: " + flightDestination);
    System.out.println("Flight time " + flightTime);
    System.out.println("Flight date: " + flightDate);
    System.out.println("Flight seat number: " + flightSeatNumber);

   }
  }
