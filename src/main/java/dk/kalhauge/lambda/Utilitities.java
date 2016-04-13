package dk.kalhauge.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
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

  public static <T> String concatenate(
      Predicate<T> includer, // a filter
      Function<T, String> converter, // a map
      BiFunction<T, T, String> delimiter,
      Iterable<T> collection
      ) {
    String text = null;
    T prev = null;
    for (T item : collection) {
      if (prev == null) text = converter.apply(item);
      else {
        text += delimiter.apply(prev, item)+converter.apply(item);
        }
      prev = item;
      }
    return text;
    }
  
  public static <T> String concatenate(
      Predicate<T> includer, // a filter
      Function<T, String> converter, // a map
      ComparativeDelimiter<T> delimiter,
      Comparator<T> comparator,
      Iterable<T> collection
      ) {
    String text = null;
    T prev = null;
    for (T item : collection) {
      if (prev == null) text = converter.apply(item);
      else {
        text += delimiter.apply(prev, item, comparator)+converter.apply(item);
        }
      prev = item;
      }
    return text;
    }
  
  }
