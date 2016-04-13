package dk.kalhauge.lambda;

import java.util.Comparator;

@FunctionalInterface
public interface ComparativeDelimiter<T> {
  
  String apply(T prev, T item, Comparator<T> comparator);
  
  }
