package FlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest6 {

  @Test
  void constructor_sets_all_fields_correctly() {
    
      FlightInformation startFlights = new FlightInformation("Bob", "Mitchell" ,70, "" ,"", "", "", "01/07/2025", "", "402"); //For reference, this is made up data.
    
      assertEquals("Bob", startFlights.getFirstName());
      assertEquals("Mitchell", startFlights.getLastName());
      assertEquals(70, startFlights.getAge());
      assertEquals("", startFlights.getGender());
      assertEquals("", startFlights.getEmailAddress());
      assertEquals("", startFlights.getPhoneNumber());
      assertEquals("", startFlights.getFlightDestination());
      assertEquals("01/07/2025", startFlights.getFlightDate());
      assertEquals("", startFlights.getFlightTime());
      assertEquals("402", startFlights.getFlightSeatNumber());

  }
}
