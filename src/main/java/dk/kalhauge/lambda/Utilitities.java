package dk.kalhauge.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Utilitities {
  
  public static <T> String concatenate(
      Predicate<T> includer,
      Function<T, String> converter,
      String delimiter,
      Iterable<T> collection
      ) {
    String text = null;
    for (T item : collection) {
      if (!includer.test(item)) continue;
      if (text == null) text = converter.apply(item);
      else text += delimiter+converter.apply(item);
      }
    return text == null ? "" : text;
    }

  }
