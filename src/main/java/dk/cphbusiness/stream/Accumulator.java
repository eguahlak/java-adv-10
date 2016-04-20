package dk.cphbusiness.stream;

@FunctionalInterface
public interface Accumulator<R, S> {

  R accumulate(R seed, S item);
  
  }
