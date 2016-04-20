package dk.cphbusiness.stream;

import java.util.function.Consumer;

public class StreamOfIterable<T> implements Stream<T> {
  private Iterable<T> items;

  public StreamOfIterable(Iterable<T> items) {
    this.items = items;
    }

  @Override
  public void forEach(Consumer<T> consumer) {
    for (T item : items) consumer.accept(item);
    }
  
  

  }
