package es.educaand.rruirey2301.clase.util;

import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

public class StringUtils {

  public static String join(Collection<String> collection, String separator) {
    StringJoiner joiner = new StringJoiner(separator);
    for (String value : collection) {
      joiner.add(value);
    }
    return joiner.toString();
  }

  public static String repeat(String value, String separator, int times) {
    StringJoiner joiner = new StringJoiner(separator);
    for (int i = 0; i < times; i++) {
      joiner.add(value);
    }
    return joiner.toString();
  }

}
