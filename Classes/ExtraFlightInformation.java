class ExtraFlightInformation {

  private static final int maxAttempts = 3;

  private static final String[] times = {
    "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30",
    "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30",
    "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
    "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
    "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
    "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"
  };

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final LocalDate startDate = LocalDate.parse("20/03/2025", formatter);
  private static final LocalDate endDate = LocalDate.parse("01/12/2026", formatter);
  private static final ArrayList<LocalDate> dates = new ArrayList<LocalDate>();

  static {
   LocalDate current = startDate;
   while (!current.isAfter(endDate)) {
      dates.add(current);
      current = current.plusDays(1);
   }
  } 

  private static final ArrayList<String> seatNumbers = new ArrayList<String>();

  static {
  for (int i = 1; i <= 500; i++) {
    seatNumbers.add(String.valueOf(i));
   }
  }

  private ArrayList<String>returnFlightDate = new ArrayList<String>();
  private ArrayList<String>returnFlightTime = new ArrayList<String>();
  private ArrayList<String>returnFlightSeatNumber = new ArrayList<String>();
  private int currentReturnIndex = 0;

  public ExtraFlightInformation(String returnFlightDate, String returnFlightTime, String returnFlightSeatNumber, int currentReturnIndex) {

    this.returnFlightDate.add(returnFlightDate);
    this.returnFlightTime.add(returnFlightTime);
    this.returnFlightSeatNumber.add(returnFlightSeatNumber);
    this.currentReturnIndex = currentReturnIndex;
  }

  public String getReturnFlightDate() {
    return returnFlightDate.get(currentReturnIndex);
  }

  public String getReturnFlightTime() {
    return returnFlightTime.get(currentReturnIndex);
  }

  public String getReturnFlightSeatNumber() {
    return returnFlightSeatNumber.get(currentReturnIndex);
  }

  public void setReturnFlightTime(String returnFlightTime) {

    if (returnFlightTime == null || returnFlightTime.trim().isEmpty()) {
      throw new IllegalReturnFlightTimeException("Return flight time is empty!");
    }

    for (int i = 0; i < times.length; i++) {
      if (returnFlightTime.equalsIgnoreCase(times[i])) {
        this.returnFlightTime.add(returnFlightTime);
        return;
        }
      }
    throw new IllegalReturnFlightTimeException("Return flight time either not available or invalid!");
  }

  public void setReturnFlightDate(String returnFlightDate) {

    if (returnFlightDate == null || returnFlightDate.trim().isEmpty()) {
      throw new IllegalReturnFlightDateException("Return Flight date is empty!");
    }

    try {
        LocalDate date = LocalDate.parse(returnFlightDate, formatter);
        if (dates.contains(date)) {
          this.returnFlightDate.add(returnFlightDate);
          return;
        }
        throw new IllegalReturnFlightDateException("Return Flight date not available or outside booking range!");
      } catch (Exception e) {
        throw new IllegalReturnFlightDateException("Invalid date format! Use dd/MM/yyyy");
      }
    }

   public void setReturnFlightSeatNumber(String returnFlightSeatNumber) {

     if (returnFlightSeatNumber == null || returnFlightSeatNumber.trim().isEmpty()) {
       throw new IllegalReturnFlightSeatNumberException("Return flight seat number is empty!");
     }

     try {
       int seatNumber = Integer.parseInt(returnFlightSeatNumber);
       if (seatNumber >= 1 && seatNumber <= 500) {
         this.returnFlightSeatNumber.add(returnFlightSeatNumber);
         return;
       }
       throw new IllegalReturnFlightSeatNumberException("Return flight seat number either invalid or out of range!");
     } catch (NumberFormatException e) {
       throw new IllegalReturnFlightSeatNumberException("It must be a number");
     } 
   }

  private static void displayAttemptsRemaining(int attempts, int maxAttempts) {
      System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }
  
  public void returnFlightTime() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

        for (int i = 0; i < times.length; i++) {
          System.out.println(times[i]);
        }

        System.out.println("Enter your return flight time shown in the listed array. You have 3 attempts to enter a valid flgiht time: ");
        String inputReturnFlightTime = sc.nextLine();
        attempts++;

        if (inputReturnFlightTime == null || inputReturnFlightTime.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid return flight time. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("No empty inputs allowed. Please try again: ");
           continue;
         }

         boolean found = false;
         for (int i = 0; i < times.length; i++) {
           if (inputReturnFlightTime.equalsIgnoreCase(times[i])) {
             found = true;
             break;
           }
         }

         if (!found) {
           if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid return flight time. Try again later: ");
              return;
            }
            displayAttemptsRemaining(attempts, maxAttempts);
            System.out.println("Sorry, the flight time is either invalid or not available in the array. Please try again: ");
           continue;
         }

         setReturnFlightTime(inputReturnFlightTime);
         break;

       } catch (IllegalArgumentException e) {
         if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid return flight time. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Error: " + e.getMessage());
       } finally {
        System.out.println("Return flight time entered successfully!");
      }
     }
   }

  public void returnFlightDate() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

        try {

          System.out.println("Enter your return flight date in the format dd/mm/yyyy between 20/03/2025 and 01/12/2026. You have 3 attempts to enter a valid flight date: ");
          String inputReturnFlightDate = sc.nextLine();
          attempts++;

          if (inputReturnFlightDate == null || inputReturnFlightDate.trim().isEmpty()) {
            if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid return flight date. Try again later: ");
              return;
             }
             displayAttemptsRemaining(attempts, maxAttempts);
             System.out.println("No empty inputs allowed. Please try again: ");
             continue;
           }

          boolean found = false;
          LocalDate date = LocalDate.parse(returnFlightDate.get(currentReturnIndex), formatter);
          if (dates.contains(date)) {
            found = true;
            break;
          }

          if (!found) {
            if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid return flight date. Try again later: ");
              return;
             }
             displayAttemptsRemaining(attempts, maxAttempts);
             System.out.println("Sorry, the flight date is either invalid or unavailable in the array. Please try again: ");
            continue;
          }

          setReturnFlightDate(inputReturnFlightDate);
          break;

        } catch (IllegalArgumentException e) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid return flight date. Try again later: ");
            return;
           }
          System.out.println("Error: " + e.getMessage());
        } finally {
        System.out.println("Return flight date entered successfully!");
      }
    }

  }

  public void returnFlightSeatNumber() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

        System.out.println("Enter a flight seat number from 1 to 500 as there are 500 seats in a plane. You have 3 attempts to enter a valid flight date: ");
        String inputReturnFlightSeatNumber = sc.nextLine();
        attempts++;

        if (inputReturnFlightSeatNumber == null || inputReturnFlightSeatNumber.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid return flight seat number. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("No empty inputs allowed. Please try again: ");
           continue;
         }

        boolean found = false;
        int seatNumber = Integer.parseInt(inputReturnFlightSeatNumber);
        if (seatNumbers.contains(String.valueOf(seatNumber))) {
          found = true;
          break;
        }

        if (!found) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid return flight seat number. Try again later: ");
            return;
           }
           displayAttemptsRemaining(attempts, maxAttempts);
           System.out.println("Sorry, the return flight seat number is either invalid or unavailable in the array. Please try again: ");
          continue;
        }

        setReturnFlightSeatNumber(inputReturnFlightSeatNumber);
        break;

      } catch (IllegalArgumentException e) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid return flight seat number. Try again later: ");
          return;
         }
        System.out.println("Error: " + e.getMessage());
      } finally {
        System.out.println("Return flight seat number entered successfully!");
      }
    }
  }
}
