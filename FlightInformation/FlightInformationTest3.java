package FlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest3 {

  @Test
  void constructor_sets_all_fields_correctly() {
    
      FlightInformation startFlights = new FlightInformation("Bob", "XYXYXYXYXYXYXYXYXYXYXYXYXYXYX" ,70, "Male" ,"BobMitchell@gmail.com", "01234567893", "Seoul", "01/07/2025", "04:00", "402"); //For reference, this is made up data.

      assertEquals("Bob", startFlights.getFirstName());
      assertEquals("XYXYXYXYXYXYXYXYXYXYXYXYXYXYX", startFlights.getLastName());
      assertEquals(70, startFlights.getAge());
      assertEquals("Male", startFlights.getGender());
      assertEquals("BobMitchell@gmail.com", startFlights.getEmailAddress());
      assertEquals("01234567893", startFlights.getPhoneNumber());
      assertEquals("Seoul", startFlights.getFlightDestination());
      assertEquals("01/07/2025", startFlights.getFlightDate());
      assertEquals("04:00", startFlights.getFlightTime());
      assertEquals("402", startFlights.getFlightSeatNumber());

  }
}
