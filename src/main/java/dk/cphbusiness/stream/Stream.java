package dk.cphbusiness.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Stream<S> {
  
  default Stream<S> filter(Predicate<S> filter) {
    return new FilteredStream<>(this, filter);
    }
  
  void forEach(Consumer<S> consumer);
  
  static <T> Stream<T> of(Iterable<T> iterable) {
    return new StreamOfIterable<>(iterable);
    }
  
  static <T> Stream<T> of(T... items) {
    return new StreamOfArray<>(items);
    }
  
  }
