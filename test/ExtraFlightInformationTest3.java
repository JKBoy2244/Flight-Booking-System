package ExtraFlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;


public class ExtraFlightInformationTest3 {

   @Test
   void constructor_sets_all_fields_correctly() {

     ExtraFlightInformation endFlights = new ExtraFlightInformation("12/67/2099", "09:37", "8544", 0);
     assertEquals("12/67/2099", endFlights.getReturnFlightDate());
     assertEquals("09:37", endFlights.getReturnFlightTime());
     assertEquals("8544", endFlights.getReturnFlightSeatNumber());

   }
}
