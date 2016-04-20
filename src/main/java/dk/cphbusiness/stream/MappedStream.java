package dk.cphbusiness.stream;

import java.util.function.Consumer;
import java.util.function.Function;

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
        (r, t) -> accumulator.accumulate(r, mapper.apply(t))
        );
    }

  }
