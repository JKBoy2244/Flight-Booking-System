import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalLastNameException extends IllegalArgumentException {
    public IllegalLastNameException(String message) {
        super(message);
    }
}
