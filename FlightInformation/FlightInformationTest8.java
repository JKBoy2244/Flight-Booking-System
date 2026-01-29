package FlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest8 {

  @Test
  void constructor_sets_all_fields_correctly() {
    
      FlightInformation startFlights = new FlightInformation("Bobttttttttttt", "Mitchellttttttttttttttttttt" ,700, "fe-male" ,"BobMitchellxxxxxx@gmail.com", "0123bbbbg4567893", "Seeoull", "091/97/202245", "04:80", "4444"); //For reference, this is made up data.
    
      assertEquals("Bobttttttttttt", startFlights.getFirstName());
      assertEquals("Mitchellttttttttttttttttttt", startFlights.getLastName());
      assertEquals(700, startFlights.getAge());
      assertEquals("fe-male", startFlights.getGender());
      assertEquals("BobMitchellxxxxxx@gmail.com", startFlights.getEmailAddress());
      assertEquals("0123bbbbg4567893", startFlights.getPhoneNumber());
      assertEquals("Seeoull", startFlights.getFlightDestination());
      assertEquals("091/97/202245", startFlights.getFlightDate());
      assertEquals("04:80", startFlights.getFlightTime());
      assertEquals("4444", startFlights.getFlightSeatNumber());

  }
}
