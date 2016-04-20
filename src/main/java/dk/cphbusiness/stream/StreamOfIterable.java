package dk.cphbusiness.stream;

import java.util.function.Consumer;

class StreamOfIterable<T> implements Stream<T> {
  private Iterable<T> items;
//  private Predicate<T> predicate = p -> true;

  public StreamOfIterable(Iterable<T> items) {
    this.items = items;
    }

//  @Override
//  public Stream<T> filter(Predicate<T> predicate) {
//    this.predicate = predicate;
//    return  this;
//    }
//  
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
  
  }
