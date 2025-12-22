package Cost;


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Cost {

   private double totalCost = 0.00;

   public Cost(double totalCost) {
     this.totalCost = totalCost;
   }

   public double getTotalCost() {
     return totalCost;
   }

   public void setTotalCost(int totalCost) {

     if (totalCost < 0) {
       throw new IllegalTotalCostException("Total cost cannot be negative!");
     }
     this.totalCost = totalCost;
   }

  public void displayCost(ValidateInformation validate, UserInformation User, long days) {

    double cost = 0.00;
    double costDay = 0.00;
    double costAge = 0.00;

    if (days < 10) {
        costDay = 50.25;
      } else if (days >= 10 && days < 20) {
        costDay = 75.25;
      } else if (days >= 20 && days < 30) {
        costDay = 95.50;
      } else {
        costDay = 110.50;
      }

      if (User.getAge() < 13) {
        costAge = 7.60;
      } else if (User.getAge() >= 13) {
        costAge = 11.40;
      }

      cost = costDay + costAge;
      this.totalCost += cost;
      System.out.println("Cost for " + days + " days: $" + String.format("%.2f", cost));
      System.out.println("Total cost: $" + String.format("%.2f", this.totalCost));
    }
}
