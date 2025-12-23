package ExtraFlightInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;


public class ExtraFlightInformationTest4 {

   public static void main(String[] args) {

     ExtraFlightInformation endFlights = new ExtraFlightInformation("12/07/2025", "", "324", 9);
     System.out.println(endFlights.getReturnFlightDate());
     System.out.println(endFlights.getReturnFlightTime());
     System.out.println(endFlights.getReturnFlightSeatNumber());

   }
}
