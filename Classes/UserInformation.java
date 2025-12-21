import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


abstract class UserInformation implements UserInterface {

  private static final int maxAttempts = 3;

  private ArrayList<String> firstName = new ArrayList<String>();
  private ArrayList<String> lastName = new ArrayList<String>();
  private ArrayList<Integer> age = new ArrayList<Integer>();
  private ArrayList<String> gender = new ArrayList<String>();
  private ArrayList<String> emailAddress = new ArrayList<String>();
  private ArrayList<String> phoneNumber = new ArrayList<String>();
  protected int currentIndex = 0;

  public UserInformation(String firstName, String lastName, int age, String gender, String emailAddress, String phoneNumber, int currentIndex) {

    this.firstName.add(firstName);
    this.lastName.add(lastName);
    this.age.add(age);
    this.gender.add(gender);
    this.emailAddress.add(emailAddress);
    this.phoneNumber.add(phoneNumber);
    this.currentIndex = currentIndex;
  }

  public String getFirstName() {
    return firstName.get(currentIndex);
  }

  public String getLastName() {
    return lastName.get(currentIndex);
  }

  public int getAge() {
    return age.get(currentIndex);
  }

  public String getGender() {
    return gender.get(currentIndex);
  }

  public String getEmailAddress() {
    return emailAddress.get(currentIndex);
  }

  public String getPhoneNumber() {
    return phoneNumber.get(currentIndex);
  } 

  public void setFirstName(String firstName) {

    if (firstName == null || firstName.trim().isEmpty()) {
      throw new IllegalFirstNameException("First name cannot be empty or null!");
    }

    if (firstName.length() > 15) {
      throw new IllegalFirstNameException("Your first name is more than 15 characters which seems too unlikely!");
    }

    this.firstName.add(firstName);
  } 

  public void setLastName(String lastName) {

    if (lastName == null || lastName.trim().isEmpty()) {
      throw new IllegalLastNameException("Last name cannot be empty or null!");
    }

    if (lastName.length() > 15) {
      throw new IllegalLastNameException("Your last name is more than 15 characters which seems too unlikely!");
    }

    this.lastName.add(lastName);
  }

  public void setAge(int age) {

    if (age < 1 || age > 99) {
      throw new IllegalAgeException("Sorry, age is outside of range from 1 to 99 years which seems invalid.");
    }

    this.age.add(age);
  }

  public void setGender(String gender) {

    if (gender == null || gender.trim().isEmpty()) {
      throw new IllegalGenderException("Sorry, gender is empty");
    }

    if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
      throw new IllegalGenderException("Sorry, gender is not male or female so invalid");
    }

    this.gender.add(gender);
  }

  public void setEmailAddress(String emailAddress) {

    if (emailAddress == null || emailAddress.trim().isEmpty()) {
         throw new IllegalEmailAddressException("Email address is empty");
     }

    if (!emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@hotmail.com")) {
         throw new IllegalEmailAddressException("Email address doesn't end with @yahoo.com, @gmail.com, or @hotmail.com!");
    }

    if (emailAddress.length() < 17 || emailAddress.length() > 25) {
        throw new IllegalEmailAddressException("Email address isn't 17 to 25 characters long!");
    }

    int Position = emailAddress.indexOf('@');

    if (Position <= 0) {
      throw new IllegalEmailAddressException("Email address must contain a username before the @ symbol!");
     }

    String localPart = emailAddress.substring(0, Position);

    for (int i = 0; i < localPart.length(); i++) {
      char c = localPart.charAt(i);
      if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
        throw new IllegalEmailAddressException("Email address is in the incorrect format unfortunately!");
      }
    }

    this.emailAddress.add(emailAddress);
  }

  public void setPhoneNumber(String phoneNumber) {

    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
       throw new IllegalPhoneNumberException("Phone number cannot be empty or null!");
     }

    if (phoneNumber.length() != 11) {
      throw new IllegalPhoneNumberException("Phone number isn't 11 digits long!");
    }

    for (int i = 0; i < phoneNumber.length(); i++) {
      if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(0) != '0') {
        throw new IllegalPhoneNumberException("Phone number isn't in valid format!");
      }
    }

    this.phoneNumber.add(phoneNumber);
  }


  private static void displayAttemptsRemaining(int attempts, int maxAttempts) {
      System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }

  public void firstName() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

       try {

        System.out.println("Enter your first name which is a max of 15 characters. If your first name is more than 15 characters long, give yourself a nick first name. You have 3 attempts to enter a valid first name: ");
        String inputFirstName = sc.nextLine();
        attempts++;

        if (inputFirstName == null || inputFirstName.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid first name. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("No empty inputs allowed. Please try again: ");
          continue;

        }

        if (inputFirstName.length() > 15) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid first name. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Sorry, your first name is over 15 characters long which seems too unlikely. Please try again: ");
          continue;
        }

        setFirstName(inputFirstName);
        break;

      } catch (IllegalArgumentException e) {
         if (attempts == maxAttempts) {
           System.out.println("You exceeded the number of attempts to enter a valid first name. Try again later: ");
           return;
         }
         System.out.println("Error: " + e.getMessage());
      } finally {
        System.out.println("first name entered successfully!");
      }
     }

    
    
   }

  public void lastName() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

       try {

        System.out.println("Enter your last name which is a max of 15 characters. If your last name is more than 15 characters long, give yourself a nick last name. You have 3 attempts to enter a valid last name: ");
         String inputLastName = sc.nextLine();
        attempts++;

        if (inputLastName == null || inputLastName.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid last name. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("No empty inputs allowed. Please try again: ");
          continue;

        }

        if (inputLastName.length() > 15) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid last name. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Sorry, your last name is over 15 characters long which seems too unlikely. Please try again: ");
          continue;
        }

        setLastName(inputLastName);
        break;

      } catch (IllegalArgumentException e) {
         if (attempts == maxAttempts) {
           System.out.println("You exceeded the number of attempts to enter a valid last name. Try again later: ");
           return;
         }
         System.out.println("Error: " + e.getMessage());
      } finally {
        System.out.println("last name entered successfully!");
      }
     }   
   }

  public void age() {

    Scanner sc = new Scanner(System.in);
    String ageStr;
    int attempts = 0;

    while (attempts < maxAttempts) {

        System.out.println("Enter a valid age from 1 to 99: ");
        ageStr = sc.nextLine();

        if (ageStr.trim().isEmpty()) {
            attempts++;
            displayAttemptsRemaining(attempts, maxAttempts);
            System.out.println("Empty inputs not allowed!");
            continue;
        }

        try {
            int inputAge = Integer.parseInt(ageStr);

            if (inputAge >= 1 && inputAge <= 99) {
                System.out.println("Valid age: " + age);
                setAge(inputAge);
                break; 
            } else {
                attempts++;
                displayAttemptsRemaining(attempts, maxAttempts);
                System.out.println("Age out of range!");
                continue;
            }
  
        } catch (IllegalAgeException e) {

            attempts++;
            displayAttemptsRemaining(attempts, maxAttempts); 
            System.out.println("Invalid input!");
            continue;
        } finally {
          System.out.println("Age entered successfully!");
        }
    }

    if (attempts == maxAttempts) {
        System.out.println("3 attempts used. Come back later!");
        return;
    }
  }

  public void gender() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

        System.out.println("Please enter female or male as your gender. You have 3 attempts to enter a valid gender: ");
        String inputGender = sc.nextLine();
        attempts++;

        if (inputGender == null || inputGender.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid gender. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("No empty inputs allowed. Please try again: ");
          continue;
        }

        if (!inputGender.equalsIgnoreCase("Male") && !inputGender.equalsIgnoreCase("Female")) {
          if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid gender. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Sorry, gender isn't male or female. Please try again: ");
          continue;
        }

        setGender(inputGender);
        break;
      } catch (IllegalArgumentException e) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid gender. Try again later: ");
          return;
        }
         System.out.println("Error: " + e.getMessage());
      } finally {
        System.out.println("Gender entered successfully!");
      }
    }
  }

  public void emailAddress() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      System.out.println("Enter your email address in either @yahoo.com, @gmail.com or @hotmail.com. We don't accept any other forms of email address. You have 3 attempts to enter a valid email address: ");
      String inputEmailAddress = sc.nextLine();
      attempts++;

      if (inputEmailAddress == null || inputEmailAddress.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid email address. Try again later: ");
          return;
        }
        displayAttemptsRemaining(attempts, maxAttempts);
        System.out.println("No empty inputs allowed. Please try again: ");
        continue;
      }

       if (inputEmailAddress.length() < 17 || inputEmailAddress.length() > 25) {
          if (attempts == maxAttempts) {
              System.out.println("You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
              return;
            }
            displayAttemptsRemaining(attempts, maxAttempts);
            System.out.println("Sorry, that's the wrong format. Please try again: ");
            continue;
          }

      if (!inputEmailAddress.endsWith("@yahoo.com") && !inputEmailAddress.endsWith("@gmail.com") && !inputEmailAddress.endsWith("@hotmail.com")) {
        if (attempts == maxAttempts) {
            System.out.println("You exceeded the number of attempts to enter a valid email address. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Sorry, that's the wrong format. Please try again: ");
          continue;
        }

      int Position = inputEmailAddress.indexOf('@');
       if (Position > 0) {
           String localPart = inputEmailAddress.substring(0, Position);
           boolean containsInvalidChar = false;

           for (int i = 0; i < localPart.length(); i++) {
               char c = localPart.charAt(i);
               if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
                   containsInvalidChar = true;
                   break;
               }
           }

           if (containsInvalidChar) {
               if (attempts == maxAttempts) {
                 System.out.println("You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
                   return;
               }
               displayAttemptsRemaining(attempts, maxAttempts);
               System.out.println("Sorry, email address can only contain letters, numbers, dots, underscores, or hyphens before the @ symbol. Please enter a valid email address:");
             inputEmailAddress = sc.nextLine();
               continue;
           }
       }

      setEmailAddress(inputEmailAddress);
      break;
     } catch (IllegalArgumentException e) {
       if (attempts == maxAttempts) {
         System.out.println("You exceeded the number of attempts to enter a valid email address. Try again later: ");
         return;
       }
       System.out.println("Error: " + e.getMessage());
    } finally {
        System.out.println("Email address entered successfully!");
      }
   } 
  }

  public void phoneNumber() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      System.out.println("Enter your phone number (11 digits long starting with 0): ");
      String inputPhoneNumber = sc.nextLine();
      attempts++;

      if (inputPhoneNumber == null || inputPhoneNumber.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        displayAttemptsRemaining(attempts, maxAttempts);
        System.out.println("No empty inputs allowed. Please try again: ");
        continue;
      }

      if (inputPhoneNumber.length() != 11) {
        if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        displayAttemptsRemaining(attempts, maxAttempts);
        System.out.println("Sorry, this phone number is not 11 digits long. Please try again: ");
        continue;
      }

      for (int i = 0; i < inputPhoneNumber.length(); i++) {
        if (!Character.isDigit(inputPhoneNumber.charAt(i)) || inputPhoneNumber.charAt(0) != '0') {
          if (attempts == maxAttempts) {
          System.out.println("You exceeded the number of attempts to enter a valid phone number. Try again later: ");
            return;
          }
          displayAttemptsRemaining(attempts, maxAttempts);
          System.out.println("Sorry, this phone number either doesn't start with 0 or has strings inside it which isnt valid. Please try again: ");
          continue;
        }
      }

       setPhoneNumber(inputPhoneNumber);
       break;
      } catch (IllegalArgumentException e) {
       if (attempts == maxAttempts) {
         System.out.println("You exceeded the number of attempts to enter a valid phone number. Try again later: ");
         return;
       }
       System.out.println("Error: " + e.getMessage());
    } finally {
        System.out.println("Phone number entered successfully!");
      }
   }
  } 

  public void confirm() {

  Scanner sc = new Scanner(System.in);
  boolean correct = false;

  while (!correct) {

    System.out.println(" Until now, you entered the following information ");
    System.out.println(" ------------------------------------------------ ");
    System.out.println("First name: " + firstName);
    System.out.println("Last name: " + lastName);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Email address: " + emailAddress);
    System.out.println("Phone number: " + phoneNumber);
    System.out.println(" ------------------------------------------------ ");

    System.out.println("Is all of the information above correct (yes/no)? 1 more chance to change it: ");
    String yesNo = sc.nextLine();

    if (yesNo == null || yesNo.trim().isEmpty()) {
      System.out.println("No empty inputs allowed. Please try again: ");
    }

    if (!yesNo.equalsIgnoreCase("yes") && !yesNo.equalsIgnoreCase("no")) {
      System.out.println("Your answer isn't yes or no so it's invalid!");
    }

    if (yesNo.equalsIgnoreCase("yes")) {
      correct = true;
    }

    if (yesNo.equalsIgnoreCase("no")) {

       System.out.println("Please re-enter all of your information but correctly this time. Last chance to change it! If some information is correct, just type the same thing as before and it's fine!");

      firstName();
      lastName();
      age();
      gender();
      emailAddress();
      phoneNumber();

    }
  }
 }

 abstract public void flightDestination();
 abstract public void flightDate();
 abstract public void flightTime();
 abstract public void flightSeatNumber();
}
