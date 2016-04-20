package dk.cphbusiness.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;

class StreamOfArray<T> implements Stream<T> {
  private final T[] items;

  public StreamOfArray(T[] items) {
    this.items = items;
    }

  @Override
  public void forEach(Consumer<T> consumer) {
    for (T item : items) consumer.accept(item);
    }
  
  @Override
  public <R> R reduce(R identity, Accumulator<R, T> accumulator) {
    R reduction = identity;
    for (T item : items) reduction = accumulator.accumulate(reduction, item);
    return reduction;
    }

  @Override
  public <R> R reduceUntil(Predicate<T> filter, R identity, Accumulator<R, T> accumulator) {
    R reduction = identity;
    for (T item : items) {
      reduction = accumulator.accumulate(reduction, item);
      if (filter.test(item)) return reduction;
      }
    return reduction;
    }

  @Override
  public int count() {
    return items.length;
    }

  @Override
  public boolean isEmpty() {
    return items.length == 0;
    }
  
  
  
  }
