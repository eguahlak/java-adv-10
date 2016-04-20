package dk.cphbusiness.stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class MappedStream<S, T> implements Stream<T> {
  private final Stream<S> source;
  private final Function<S, T> mapper;

  public MappedStream(Stream<S> source, Function<S, T> mapper) {
    this.source = source;
    this.mapper = mapper;
    }

  @Override
  public void forEach(Consumer<T> consumer) {
    source.forEach(s -> consumer.accept(mapper.apply(s)));
    }

  @Override
  public <R> R reduce(R identity, Accumulator<R, T> accumulator) {
    return source.reduce(
        identity, 
        (r, s) -> accumulator.accumulate(r, mapper.apply(s))
        );
    }

  @Override
  public <R> R reduceUntil(Predicate<T> filter, R identity, Accumulator<R, T> accumulator) {
    return source.reduceUntil(
        s -> filter.test(mapper.apply(s)), 
        identity, 
        (r, s) -> accumulator.accumulate(r, mapper.apply(s))
        );
    }
  

  @Override
  public int count() {
    return source.count();
    }

  @Override
  public boolean isEmpty() {
    return source.isEmpty();
    }
  
  }
