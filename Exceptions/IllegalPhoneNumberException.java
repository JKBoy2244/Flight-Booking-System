import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalPhoneNumberException extends IllegalArgumentException {
    public IllegalPhoneNumberException(String message) {
        super(message);
    }
}
