package ValidateInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import FlightInformation.FlightInformation;
import ExtraFlightInformation.ExtraFlightInformation;


public class ValidateInformationTest {
    public static void main(String[] args) {

        FlightInformation startFlights = new FlightInformation("Bob", "Mitchell" ,70, "Male" ,"BobMitchell@gmail.com", "0123456789", "Seoul", "01/07/2025", "04:00", "402"); //For reference, this is made up data.
        ExtraFlightInformation endFlights = new ExtraFlightInformation("05:30", "09:30", "324", 1);
        
        ValidateInformation validate = new ValidateInformation(startFlights, endFlights);

        System.out.println("ValidateInformationTest ran.");
    }
}
