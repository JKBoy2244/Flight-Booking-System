package ValidateInformation;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import FlightInformation.FlightInformation;
import ExtraFlightInformation.ExtraFlightInformation;


public class ValidateInformationTest2 {
    public static void main(String[] args) {

        FlightInformation startFlights = new FlightInformation("", "" ,7056666, "Male" ,"", "0123456789566tgfd", "Seoul", "01/07/2025", "04:00", "572"); //For reference, this is made up data.
        ExtraFlightInformation endFlights = new ExtraFlightInformation("05:30", "", "724", 1);
        
        ValidateInformation validate = new ValidateInformation(startFlights, endFlights);

         assertDoesNotThrow(() -> {
            new ValidateInformation(startFlights, endFlights);
        });
    }
}
