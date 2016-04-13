package dk.cphbusiness.stream;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Stream<T> {
  Stream<T> filter(Predicate<T> predicate);
  <R> Stream<R> map(Function<T, R> function);
  <U> U reduce(U identity, BinaryOperator<T> accumulator);
  Iterator<T> iterator();
  void forEach(Consumer<T> consumer);
  int count();
  
  static <T> Stream<T> of(Iterable<T> collection) {
    throw new UnsupportedOperationException("No support");
    }
  
  }
