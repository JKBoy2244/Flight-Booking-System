package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalReturnFlightDateException extends IllegalArgumentException {
    public IllegalReturnFlightDateException(String message) {
        super(message);
    }
}
