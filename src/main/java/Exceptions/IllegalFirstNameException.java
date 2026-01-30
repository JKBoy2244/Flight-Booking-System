package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalFirstNameException extends IllegalArgumentException {
    public IllegalFirstNameException(String message) {
        super(message);
    }
}
