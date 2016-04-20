package dk.cphbusiness.stream;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Stream<S> {
  
  default Stream<S> filter(Predicate<S> filter) {
    return new FilteredStream<>(this, filter);
    }
  
  default <T> Stream<T> map(Function<S, T> mapper) {
    return new MappedStream<>(this, mapper);
    }
  
  default <R> R reduce(R identity, Accumulator<R, S> accumulator) {
    return reduceUntil(s -> false, identity, accumulator);
    }
  
  default int count() {
    return reduce(0, (r, t) -> r + 1);
    }
  
  default boolean isEmpty() {
    return count() == 0;
    }
  
  void forEach(Consumer<S> consumer);
  
  <R> R reduceUntil(Predicate<S> filter, R identity, Accumulator<R, S> accumulator);
  
  default S first() {
    return reduceUntil(p -> true, null, (r, s) -> s);
    }
  
  static <T> Stream<T> of(Iterable<T> iterable) {
    return new StreamOfIterable<>(iterable);
    }
  
  static <T> Stream<T> of(T... items) {
    return new StreamOfArray<>(items);
    }
  
  }
