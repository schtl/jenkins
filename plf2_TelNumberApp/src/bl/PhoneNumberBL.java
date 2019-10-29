/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Random;

/**
 *
 * @author SF
 */
public class PhoneNumberBL {

  public static String createPhoneNumber() {
    String telNr = "+43/";
    Random rand = new Random();
    int first = rand.nextInt(7) + 1;
    telNr += first;
    for (int i = 0; i < rand.nextInt(4) + 1; i++) {
      telNr += (rand.nextInt(9) + 1);
    }
    int second = Integer.parseInt(telNr.charAt(5) + "");
    if (first == 6 && second >= 5 && second <= 9) {
      telNr += String.format("/%d.%03d.%03d", rand.nextInt(89) + 10,
              rand.nextInt(1000),
              rand.nextInt(1000));
    } else {
      telNr += String.format("/%d.%02d.%02d", rand.nextInt(89) + 10,
              rand.nextInt(100),
              rand.nextInt(100));
    }
    return telNr;
  }

  public static String getArea(String number) {
    String[] tokens = number.split("/");
    char first = tokens[1].charAt(0);
    int areaCode = Integer.parseInt(tokens[1]);
    switch (first) {
      case '1':
        return "W";
      case '2':
        return "NÖ";
      case '3':
        return "ST";
      case '4':
        return "K";
      case '5':
        return "T-V";
      case '6':
        if (areaCode > 1 && (Integer.parseInt(tokens[1].charAt(1) + "") >= 5)) {
          return "Mobil";
        }
        return "S";
      case '7':
        return "OÖ";
    }
    return "Illegal Areacode";
  }

  public static boolean checkPhoneNumber(String number) throws NumberFormatException
  {
    try {
      String[] tokens = number.split("/");
      if (number.startsWith("+43/") && tokens.length == 3) {
        int num1 = Integer.parseInt(tokens[1]);
        int first = Integer.parseInt(tokens[1].charAt(0) + "");
        if (first >= 1 && first <= 7 && tokens[1].length() < 6) {
          String[] parts = tokens[2].split("\\.");
          if (parts.length == 3) {
            int z1 = Integer.parseInt(parts[0]);
            int z2 = Integer.parseInt(parts[1]);
            int z3 = Integer.parseInt(parts[2]);
            if (z1 >= 10 && z1 < 100) {
              int second = tokens[1].length() > 1 ? Integer.parseInt(tokens[1].charAt(1)+"") : 0;
              int len = (first == 6 && second >= 5 && second <= 9) ? 3 : 2;
              if (parts[1].length() == len && parts[2].length() == len) {
                return true;
              }
            }
          }
        }
      }
    } catch (NumberFormatException ex) {
      throw new NumberFormatException("Invalid number");
    }
    return false;
  }
}
