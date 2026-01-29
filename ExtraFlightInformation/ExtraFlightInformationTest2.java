package ExtraFlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;


public class ExtraFlightInformationTest2 {

   @Test
   void constructor_sets_all_fields_correctly() {

     ExtraFlightInformation endFlights = new ExtraFlightInformation("", "", "", 0);
     assertEquals("", endFlights.getReturnFlightDate());
     assertEquals("", endFlights.getReturnFlightTime());
     assertEquals("", endFlights.getReturnFlightSeatNumber());

   }
}
