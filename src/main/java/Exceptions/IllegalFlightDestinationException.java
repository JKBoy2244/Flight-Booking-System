package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalFlightDestinationException extends IllegalArgumentException {
    public IllegalFlightDestinationException(String message) {
        super(message);
    }
}
