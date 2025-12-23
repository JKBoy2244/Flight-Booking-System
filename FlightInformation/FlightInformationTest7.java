package FlightInformation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest7 {

  public static void main(String[] args) {
    
      FlightInformation startFlights = new FlightInformation("Bob", "Mitchell" ,70, "Male" ,"BobMitchellxxxxxxxxxxx@gmail.com", "012345678935555556664", "Seoul", "01/17/2099", "04:10", "882"); //For reference, this is made up data.
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
