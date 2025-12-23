package FlightInformation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest2 {

  public static void main(String[] args) {
    
      FlightInformation startFlights = new FlightInformation("XYXYXYXYXYXYXYXYXYXYXYXYXYXYXYXY", "Mitchell" ,70, "Male" ,"BobMitchell@gmail.com", "01234567893", "Seoul", "01/07/2025", "04:00", "402"); //For reference, this is made up data.
      System.out.println(startFlights.getFirstName());
      System.out.println(startFlights.getLastName());
      System.out.println(startFlights.getAge());
      System.out.println(startFlights.getGender());
      System.out.println(startFlights.getEmailAddress());
      System.out.println(startFlights.getPhoneNumber());
      System.out.println(startFlights.getFlightDestination());
      System.out.println(startFlights.getFlightDate());
      System.out.println(startFlights.getFlightTime());
      System.out.println(startFlights.getFlightSeatNumber());

  }
}
