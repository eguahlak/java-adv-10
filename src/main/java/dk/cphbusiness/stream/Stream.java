package dk.cphbusiness.stream;

import java.util.function.Consumer;

public interface Stream<S> {
  
  void forEach(Consumer<S> consumer);
  
  static <T> Stream<T> of(Iterable<T> iterable) {
    return new StreamOfIterable<>(iterable);
    }
  
  static <T> Stream<T> of(T... items) {
    return new StreamOfArray<>(items);
    }
  
  }
