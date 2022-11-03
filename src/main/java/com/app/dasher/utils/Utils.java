package com.app.dasher.utils;

import java.security.Key;
import java.util.Date;
import java.util.Random;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:43 am
 * @company NextUp
 */
public class Utils {
  private static final Random randomGenerator = new Random();
  private static final String JWT_ALGO_TYPE = "DES";
  private static final String APP_NAME = "Dash";
  private static final String APP_SUBJECT = "Debugged";
  private static Key key;
  private static String jwt;
  private static String TEMP_URL = "";

  public static int randomInteger(int min, int max) {
    return randomGenerator.nextInt(max - min) + min;
  }

  public static String generateId() {
    return String.valueOf(System.currentTimeMillis() * 100 + randomInteger(1, 9));
  }

  public static String generateOTP() {
    Random rnd = new Random();
    int number = rnd.nextInt(9999);
    return String.format("%04d", number);
  }

  public static long getCurrentTime() {
    return new Date().getTime();
  }
}
