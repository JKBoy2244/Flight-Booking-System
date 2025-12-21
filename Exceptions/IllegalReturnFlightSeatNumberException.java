import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalReturnFlightSeatNumberException extends IllegalArgumentException {
    public IllegalReturnFlightSeatNumberException(String message) {
        super(message);
    }
}
