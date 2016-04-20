package dk.cphbusiness.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;

class FilteredStream<T> implements Stream<T> {
  private Stream<T> source;
  private Predicate<T> filter;

  public FilteredStream(Stream<T> source, Predicate<T> filter) {
    this.source = source;
    this.filter = filter;
    }

  @Override
  public void forEach(Consumer<T> consumer) {
    source.forEach(t -> { if (filter.test(t)) consumer.accept(t); });
    }

  @Override
  public <R> R reduce(R identity, Accumulator<R, T> accumulator) {
    return source.reduce(
        identity,
        (r, t) -> filter.test(t) ? accumulator.accumulate(r, t) : r
        );
    }
  
  }
