package FlightInformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import Interface.UserInterface;

public class FlightInformationTest7 {

  @Test
  void constructor_sets_all_fields_correctly() {
    
      FlightInformation startFlights = new FlightInformation("Bob", "Mitchell" ,70, "Male" ,"BobMitchellxxxxxxxxxxx@gmail.com", "012345678935555556664", "Seoul", "01/17/2099", "04:10", "882"); //For reference, this is made up data.
    
      assertEquals("Bob", startFlights.getFirstName());
      assertEquals("Mitchell", startFlights.getLastName());
      assertEquals(70, startFlights.getAge());
      assertEquals("Male", startFlights.getGender());
      assertEquals("BobMitchellxxxxxxxxxxx@gmail.com", startFlights.getEmailAddress());
      assertEquals("012345678935555556664", startFlights.getPhoneNumber());
      assertEquals("Seoul", startFlights.getFlightDestination());
      assertEquals("01/17/2099", startFlights.getFlightDate());
      assertEquals("04:00", startFlights.getFlightTime());
      assertEquals("882", startFlights.getFlightSeatNumber());

  }
}
