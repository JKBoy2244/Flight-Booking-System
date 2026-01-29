package ExtraFlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;


public class ExtraFlightInformationTest1 {

   @Test
   void constructor_sets_all_fields_correctly() {

     ExtraFlightInformation endFlights = new ExtraFlightInformation("12/07/2025", "09:30", "324", 1);
     assertEquals("12/07/2025", endFlights.getReturnFlightDate());
     assertEquals("09:30", endFlights.getReturnFlightTime());
     assertEquals("324", endFlights.getReturnFlightSeatNumber());

   }
}
