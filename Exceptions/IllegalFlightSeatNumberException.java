import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalFlightSeatNumberException extends IllegalArgumentException {
    public IllegalFlightSeatNumberException(String message) {
        super(message);
    }
}
