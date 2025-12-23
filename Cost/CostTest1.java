package Cost;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Exceptions.*;
import ValidateInformation.ValidateInformation;
import FlightInformation.UserInformation;

public class CostTest1 {

  public static void main(String[] args) {

    Cost cost = new Cost(1.20);
    System.out.println(cost.getTotalCost());
  }
}
