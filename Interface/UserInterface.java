import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


interface UserInterface {
  public void firstName();
  public void lastName();
  public void age();
  public void gender();
  public void emailAddress();
  public void phoneNumber();
  public void confirm();
}
