package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class IllegalAgeException extends IllegalArgumentException {
    public IllegalAgeException(String message) {
        super(message);
    }
}
