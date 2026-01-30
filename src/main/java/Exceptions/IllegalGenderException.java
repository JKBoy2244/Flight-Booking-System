package Exceptions;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class IllegalGenderException extends IllegalArgumentException {
    public IllegalGenderException(String message) {
        super(message);
    }
}
