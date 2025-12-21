import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalReturnFlightTimeException extends IllegalArgumentException {
    public IllegalReturnFlightTimeException(String message) {
        super(message);
    }
}
