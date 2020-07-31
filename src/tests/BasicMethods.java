package tests;

public class BasicMethods {

  public static String toMayusq(String lowerString) {

    String upperString = lowerString.substring(0, 1).toUpperCase() + lowerString.substring(1);

    return upperString;
  }
}
