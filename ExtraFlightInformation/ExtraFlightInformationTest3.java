package ExtraFlightInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;


public class ExtraFlightInformationTest3 {

   public static void main(String[] args) {

     ExtraFlightInformation endFlights = new ExtraFlightInformation("12/67/2099", "09:37", "8544", 0);
     System.out.println(endFlights.getReturnFlightDate());
     System.out.println(endFlights.getReturnFlightTime());
     System.out.println(endFlights.getReturnFlightSeatNumber());

   }
}
