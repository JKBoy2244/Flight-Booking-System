package Exceptions,

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalFlightDateException extends IllegalArgumentException {
    public IllegalFlightDateException(String message) {
        super(message);
    }
}
