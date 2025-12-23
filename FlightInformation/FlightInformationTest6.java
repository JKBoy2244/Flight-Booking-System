package FlightInformation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest6 {

  public static void main(String[] args) {
    
      FlightInformation startFlights = new FlightInformation("Bob", "Mitchell" ,70, "" ,"", "", "", "01/07/2025", "", "402"); //For reference, this is made up data.
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
