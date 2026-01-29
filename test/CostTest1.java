package Cost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import ValidateInformation.ValidateInformation;
import FlightInformation.UserInformation;

public class CostTest1 {

  @Test
  void constructor_sets_all_fields_correctly() {

    Cost cost = new Cost(1.20);
    assertEquals(1.20, cost.getTotalCost());
  }
}
