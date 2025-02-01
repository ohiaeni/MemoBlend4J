package com.memoblend.systemcommon.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日付の変換を行うクラスです。
 */
public class LocalDateConverter {

  /**
   * long型の日付をLocalDate型に変換します。
   * 
   * @param date long型の日付
   * @return LocalDate型の日付
   */
  public static LocalDate convert(long date) {
    String dateString = String.valueOf(date);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
  }
}
