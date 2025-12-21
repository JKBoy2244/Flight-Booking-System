class Main {

  public static void main(String[] args) {

    while (true) {

      Intro intro = new Intro();
      intro.displayMessage();
      System.out.println("Wait for 2 seconds!");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace(); 
        }

      FlightInformation startFlights = new FlightInformation("","",0,"","","","","","","");
      startFlights.firstName();
      startFlights.lastName();
      startFlights.age();
      startFlights.gender();
      startFlights.emailAddress();
      startFlights.phoneNumber();
      startFlights.flightDestination();
      startFlights.flightDate();
      startFlights.flightTime();
      startFlights.flightSeatNumber();
      startFlights.confirm();
      System.out.println("Wait for 2 seconds!");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace(); 
      }


      ExtraFlightInformation endFlights = new ExtraFlightInformation("","","",0);
      endFlights.returnFlightDate();
      endFlights.returnFlightTime();
      endFlights.returnFlightSeatNumber();
      System.out.println("Wait for 2 seconds!");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace(); 
        }

      ValidateInformation validate = new ValidateInformation(startFlights, endFlights);
      validate.validateFlightInformation();

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace(); 
        }

      Cost cost = new Cost(0.00);
      cost.displayCost(validate, startFlights, java.time.temporal.ChronoUnit.DAYS.between(LocalDate.parse(startFlights.getFlightDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse(endFlights.getReturnFlightDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

    }
  }
}
