package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalFlightTimeException extends IllegalArgumentException {
    public IllegalFlightTimeException(String message) {
        super(message);
    }
}
